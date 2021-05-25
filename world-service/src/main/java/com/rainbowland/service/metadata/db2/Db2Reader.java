package com.rainbowland.service.metadata.db2;

import com.rainbowland.utils.Utils;
import lombok.SneakyThrows;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Db2Reader<T> {

    private static final int FILE_HEADER_SIZE = 72;


    private static final int FIELD_COMPRESSION_NONE = 0;
    private static final int FIELD_COMPRESSION_BITPACKED = 1;
    private static final int FIELD_COMPRESSION_COMMON_DATA = 2;
    private static final int FIELD_COMPRESSION_BITPACKED_INDEXED = 3;
    private static final int FIELD_COMPRESSION_BITPACKED_INDEXED_ARRAY = 4;
    private static final int FIELD_COMPRESSION_BITPACKED_SIGNED = 5;

    private Charset charset = StandardCharsets.UTF_8;
    private RandomAccessFile fileHandle;
    private Class<T> domainClass;
    private String fileFormat;
    private String fileName;
    private long fileSize = 0;

    private long headerSize = 0;
    private int recordCount = 0;
    private int fieldCount = 0;
    private int totalFieldCount = 0;
    private int recordSize = 0;
    private long stringBlockPos = 0;
    private int stringBlockSize = 0;
    private int tableHash = 0;
    private int layoutHash = 0;
    private int timestamp = 0;
    private int build = 0;
    private int minId = 0;
    private int maxId = 0;
    private int locale = 0;
    private long copyBlockPos = 0;
    private int copyBlockSize = 0;
    private int flags = 0;

    private long commonBlockPos = 0;
    private int commonBlockSize = 0;
    private int bitpackedDataPos = 0;
    private int lookupColumnCount = 0;
    private int idBlockSize = 0;
    private long fieldStorageInfoPos = 0;
    private int fieldStorageInfoSize = 0;
    private long palletDataPos = 0;
    private int palletDataSize = 0;
    private long relationshipDataPos = 0;
    private int relationshipDataSize = 0;

    private int sectionCount = 0;
    private SectionHeader[] sectionHeaders;

    private int idField = -1;

    private boolean hasEmbeddedStrings = false;
    private boolean hasIdBlock = false;
    private boolean hasIdsInIndexBlock = false;

    private int indexBlockPos = 0;
    private int idBlockPos = 0;

    private FieldMeta[] fieldMetas;
    private ColumnMeta[] columnMetas;

    private List<int[]> palletArray = new ArrayList<>();
    private List<IntIntHashMap> commonValues = new ArrayList<>();

    private Map<Integer,Row> records = new LinkedHashMap<>();


    @SneakyThrows
    public Db2Reader(File db2File, Class<T> domainClass) {
        this.fileName = db2File.getName();
        this.fileHandle = new RandomAccessFile(db2File, "r");
        this.fileSize = fileHandle.length();
        this.domainClass = domainClass;
    }

    private void close() throws IOException {
        fileHandle.close();
    }

    @SneakyThrows
    private List<T> readRows() {
        openWdc3();
        return records.values().stream().map(Row::map).collect(Collectors.toList());
    }


    private void openWdc3() throws IOException {
        if (this.fileSize < FILE_HEADER_SIZE) {
            throw new IOException(String.format("WDC3 file %s is corrupted or empty!", fileName));
        }
        this.fileFormat = readString(4);
        if (!"WDC3".equals(fileFormat)) {
            throw new IOException("Unknown DB2 format: " + this.fileFormat);
        }

        this.recordCount = fileHandle.readInt();
        this.fieldCount = fileHandle.readInt();
        this.recordSize = fileHandle.readInt();
        this.stringBlockSize = fileHandle.readInt();
        this.tableHash = fileHandle.readInt();
        this.layoutHash = fileHandle.readInt();
        this.minId = fileHandle.readInt();
        this.maxId = fileHandle.readInt();
        this.locale = fileHandle.readInt();

        this.flags = fileHandle.readUnsignedShort();
        this.idField = fileHandle.readUnsignedShort();

        this.totalFieldCount = fileHandle.readInt();
        this.bitpackedDataPos = fileHandle.readInt();
        this.lookupColumnCount = fileHandle.readInt();
        this.fieldStorageInfoSize = fileHandle.readInt();
        this.commonBlockSize = fileHandle.readInt();
        this.palletDataSize = fileHandle.readInt();
        this.sectionCount = fileHandle.readInt();

        this.hasEmbeddedStrings = (this.flags & 1) > 0;
        this.hasIdBlock = (this.flags & 4) > 0;
        if (this.sectionCount == 0) {
            return;
        }
        sectionHeaders = new SectionHeader[this.sectionCount];

        long eof = 0;
        boolean hasRelationshipData = false;
        int recordCountSum = 0;

        for (int i = 0; i < this.sectionCount; i++) {
            SectionHeader section = new SectionHeader();
            sectionHeaders[i] = section;
            section.tactKey = fileHandle.readLong();
            section.offset = fileHandle.readInt();
            section.recordCount = fileHandle.readInt();
            section.stringTableSize = fileHandle.readInt();
            section.offsetRecordsEnd = fileHandle.readInt();
            section.idListSize = fileHandle.readInt();
            section.relationshipDataSize = fileHandle.readInt();
            section.offsetMapIdCount = fileHandle.readInt();
            section.copyTableCount = fileHandle.readInt();

            if (!hasEmbeddedStrings) {
                section.stringBlockPos = section.offset + (section.recordCount * recordSize);
            } else {
                section.stringBlockPos = section.offsetRecordsEnd; // - $section['offset'] ?
                section.stringTableSize = 0;
            }
            section.idBlockPos = section.stringBlockPos + section.stringTableSize;
            // isBlockSize in section headers
            section.copyBlockPos = section.idBlockPos + section.idListSize;
            section.copyBlockSize = section.copyTableCount * 8;
            section.indexBlockPos = section.copyBlockPos + section.copyBlockSize;
            section.indexBlockSize = section.offsetMapIdCount * 6;
            section.relationshipDataPos = section.indexBlockPos + section.indexBlockSize;
            // relationshipDataSize in section headers

            section.indexIdListPos = section.relationshipDataPos + section.relationshipDataSize;
            section.indexIdListSize = section.offsetMapIdCount * 4;
            eof += section.size = section.indexIdListPos + section.indexIdListSize - section.offset;

            section.encrypted = false;
            if (section.tactKey != 0) {
                // Determine whether this section is available if it starts with any non-zero bytes
                long workingPos = fileHandle.getFilePointer();
                fileHandle.seek(section.offset);
                section.encrypted = StringUtils.hasText(readString(Math.min(1024, section.size)));
                fileHandle.seek(workingPos);
            }
            hasRelationshipData = section.relationshipDataSize > 0;
            recordCountSum += section.recordCount;
            section.relationshipDataLookup = new IntIntHashMap();
            if (!section.encrypted && section.relationshipDataSize > 0) {
                long workingPos = fileHandle.getFilePointer();
                fileHandle.seek(section.relationshipDataPos);
                int count = fileHandle.readInt();
                int min = fileHandle.readInt();
                int max = fileHandle.readInt();
                for (int j = 0; j < count; j++) {
                    section.relationshipDataLookup.put(fileHandle.readInt(), fileHandle.readInt());
                }
                fileHandle.seek(workingPos);
            }
        }
        headerSize = fileHandle.getFilePointer() + fieldCount * 4L;
        if (recordCount != recordCountSum) {
            throw new IOException(String.format("Expected %d records, found %d records in %d sections %s", recordCount, recordCountSum, sectionCount, fileName));
        }
        if (recordCount == 0) {
            return;
        }
        if (fieldStorageInfoSize != totalFieldCount * 24) {
            throw new IOException(String.format("Expected %d bytes for storage info, instead found %d %s", totalFieldCount * 24, fieldStorageInfoSize, fileName));
        }
        if (hasEmbeddedStrings) {
            if (!hasIdBlock) {
                throw new IOException("File has embedded strings and no ID block, which was not expected, aborting %s".formatted(fileName));
            }
        }

        fieldStorageInfoPos = headerSize;
        palletDataPos = fieldStorageInfoPos + fieldStorageInfoSize;
        commonBlockPos = palletDataPos + palletDataSize;
        eof += commonBlockPos + commonBlockSize;
        if (eof != fileSize) {
            throw new IOException(String.format("Expected size: %d, actual size:%d %s", eof, fileSize, fileName));
        }

        // field meta data
        this.fieldMetas = new FieldMeta[this.fieldCount];
        for (int i = 0; i < this.fieldCount; i++) {
            FieldMeta fieldMeta = new FieldMeta();
            fieldMetas[i] = fieldMeta;
            fieldMeta.bitShift = fileHandle.readUnsignedShort();
            fieldMeta.offset = fileHandle.readUnsignedShort();
            // Math.ceil((32 - this.recordFormat[$fieldId]['bitShift']) / 8)
            fieldMeta.valueLength = (int) Math.ceil((32 - fieldMeta.bitShift) >> 3);
        }

        int commonBlockPointer = 0;
        int palletBlockPointer = 0;

        fileHandle.seek(fieldStorageInfoPos);
        //$storageInfoFormat = 'voffsetBits/vsizeBits/VadditionalDataSize/VstorageType/VbitpackOffsetBits/VbitpackSizeBits/VarrayCount';
        // column meta data
        this.columnMetas = new ColumnMeta[this.fieldCount];
        for (int i = 0; i < columnMetas.length; i++) {
            ColumnMeta columnMeta = new ColumnMeta();
            columnMetas[i] = columnMeta;
            columnMeta.bitOffset = fileHandle.readUnsignedShort();
            columnMeta.bitSize = fileHandle.readUnsignedShort();
            columnMeta.additionalDataSize = fileHandle.readInt();
            columnMeta.storageType = fileHandle.readInt();
            columnMeta.bitPackOffsetBits = fileHandle.readInt();
            columnMeta.bitPackSizeBits = fileHandle.readInt();
            columnMeta.arrayCount = fileHandle.readInt();
            switch (columnMeta.storageType) {
                case FIELD_COMPRESSION_COMMON_DATA:
                    columnMeta.size = 4;
                    columnMeta.valueCount = 1;
                    columnMeta.defaultValue = columnMeta.bitPackOffsetBits;
                    columnMeta.bitPackOffsetBits = 0;
                    columnMeta.blockOffset = commonBlockPointer;
                    commonBlockPointer += columnMeta.additionalDataSize;
                    break;
                case FIELD_COMPRESSION_BITPACKED_SIGNED:
                    columnMeta.signed = true;
                    // fall through
                case FIELD_COMPRESSION_BITPACKED:
                    columnMeta.size = 4;
                    columnMeta.offset = (int) Math.floor(columnMeta.bitOffset / 8);
                    columnMeta.valueLength = (int) Math.ceil((columnMeta.bitOffset + columnMeta.bitSize) / 8) - columnMeta.offset + 1;
                    columnMeta.valueCount = 1;
                    break;
                case FIELD_COMPRESSION_BITPACKED_INDEXED:
                case FIELD_COMPRESSION_BITPACKED_INDEXED_ARRAY:
                    columnMeta.size = 4;
                    columnMeta.offset = (int) Math.floor(columnMeta.bitOffset / 8);
                    columnMeta.valueLength = (int) Math.ceil((columnMeta.bitOffset + columnMeta.bitSize) / 8) - columnMeta.offset + 1;
                    columnMeta.valueCount = columnMeta.arrayCount > 0 ? columnMeta.arrayCount : 1;
                    columnMeta.blockOffset = palletBlockPointer;
                    palletBlockPointer += columnMeta.additionalDataSize;
                    break;
                case FIELD_COMPRESSION_NONE:
                    if (columnMeta.arrayCount > 0) {
                        columnMeta.valueCount = columnMeta.arrayCount;
                    }
                    break;
                default:
                    throw new IOException("Unknown field compression type ID: %d".formatted(columnMeta.storageType));
            }
        }

        if (!hasIdBlock) {
            if (idField >= fieldCount) {
                throw new IOException("Expected ID field %d does not exist. Only found %d fields.".formatted(idField, fieldCount));
            }
            if (columnMetas[idField].valueCount != 1) {
                throw new IOException("Expected ID field %d reportedly has %d values per row".formatted(idField, columnMetas[idField].valueCount));
            }
        }
        // pallet data
        for (ColumnMeta columnMeta : columnMetas) {
            if (columnMeta.storageType == FIELD_COMPRESSION_BITPACKED_INDEXED
                    || columnMeta.storageType == FIELD_COMPRESSION_BITPACKED_INDEXED_ARRAY) {
                int size = columnMeta.additionalDataSize / 4;
                int[] palletArray = new int[size];
                for (int i = 0; i < palletArray.length; i++) {
                    palletArray[i] = fileHandle.readInt();
                }
                this.palletArray.add(palletArray);
            }
        }

        // common data
        for (ColumnMeta columnMeta : columnMetas) {
            if (columnMeta.storageType == FIELD_COMPRESSION_COMMON_DATA) {
                int size = columnMeta.additionalDataSize / 8;
                IntIntHashMap commonValues = new IntIntHashMap(size);
                for (int i = 0; i < size; i++) {
                    commonValues.put(fileHandle.readInt(), fileHandle.readInt());
                }
                this.commonValues.add(commonValues);
            }
        }

        long previousStringTableSize = 0;
        long previousRecordCount = 0;
        for (SectionHeader section : sectionHeaders) {
            if (section.tactKey != 0) {
                previousStringTableSize += section.stringTableSize;
                previousRecordCount += section.recordCount;
                continue;
            }
            byte[] recordsData;
            LongObjectHashMap<String> stringsTable;
            if (!hasEmbeddedStrings) {
                recordsData = new byte[section.recordCount * recordSize];
                stringsTable = new LongObjectHashMap<>(section.stringTableSize);
                // records data
                fileHandle.seek(section.offset);
                fileHandle.read(recordsData);
                // string data
                for (int i = 0; i < section.stringTableSize; ) {
                    long oldPos = fileHandle.getFilePointer();
                    stringsTable.put(i + previousStringTableSize, readCString());
                    i += (int) (fileHandle.getFilePointer() - oldPos);
                }
            } else {
                recordsData = new byte[section.offsetRecordsEnd - section.offset];
                fileHandle.read(recordsData);
                if (fileHandle.getFilePointer() != section.offsetRecordsEnd) {
                    throw new IOException("db2File.position != section.indexRecordsEnd");
                }
            }

            // index data
            int[] idList = new int[section.idListSize / 4];
            for (int i = 0; i < idList.length; i++) {
                idList[i] = fileHandle.readInt();
            }
            boolean isIndexEmpty = hasIdBlock && Arrays.equals(idList, new int[section.recordCount]);


            // duplicate rows data
            IntIntHashMap copyData = new IntIntHashMap();
            for (int i = 0; i < section.copyTableCount; i++) {
                copyData.put(fileHandle.readInt(), fileHandle.readInt());
            }

            OffsetMapEntry[] offsetMapEntries = new OffsetMapEntry[section.offsetMapIdCount];
            for (int i = 0; i < offsetMapEntries.length; i++) {
                offsetMapEntries[i] = new OffsetMapEntry();
                offsetMapEntries[i].offset = fileHandle.readInt();
                offsetMapEntries[i].size = fileHandle.readUnsignedShort();
            }
            // reference data
            Relationship relationship = new Relationship();
            if (section.relationshipDataSize > 0) {
                relationship.numEntries = fileHandle.readInt();
                relationship.minId = fileHandle.readInt();
                relationship.maxId = fileHandle.readInt();

                IntIntHashMap entries = new IntIntHashMap();
                for (int i = 0; i < relationship.numEntries; i++) {
                    // This is the id of the foreign key for the record, e.g. SpellID in SpellX* tables.
                    int foreignId = fileHandle.readInt();
                    // This is the index of the record in record_data.  Note that this is *not* the record's own ID.
                    int recordIndex = fileHandle.readInt();
                    entries.put(recordIndex, foreignId);
                }
                relationship.entries = entries;
            } else {

            }

            int[] offsetMapIdList = new int[section.offsetMapIdCount];
            for (int i = 0; i < offsetMapIdList.length; i++) {
                offsetMapIdList[i] = fileHandle.readInt();
            }

            if (hasIdBlock && offsetMapEntries.length != offsetMapIdList.length) {
                throw new IOException("idList.Length != sparseIndexData.Length");
            }

            //BitReader bitReader = new (recordsData);
            for (int i = 0; i < section.recordCount; ++i) {

                int offset = hasEmbeddedStrings ? offsetMapEntries[i].offset - section.offset : i * recordSize;

                int refId = relationship.entries.getIfAbsent(i, -1);
                boolean hasRef = refId == -1;

                long recordIndex = i + previousRecordCount;
                long recordOffset = (recordIndex * recordSize) - ((long) recordCount * recordSize);

                Row row = new Row(recordsData, offset, (int) recordOffset, hasIdBlock ? (isIndexEmpty ? i : idList[i]) : -1, hasRef ? refId : -1);
                records.put(row.id, row);
            }

            copyData.forEachKeyValue((k, v) -> {
                Row copyRow = new Row(records.get(v));
                copyRow.id = k;
                records.put(copyRow.id, copyRow);
            });

            previousStringTableSize += section.stringTableSize;
            previousRecordCount += section.recordCount;

        }

    }

    private String readCString() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (true) {
            int read = fileHandle.read();
            if (read == '0') break;
            out.write(read);
        }
        return out.toString(charset);
    }

    private String readString(int length) throws IOException {
        byte[] array = new byte[length];
        fileHandle.read(array);
        return new String(array, charset);
    }

    private static class SectionHeader {
        private long tactKey;
        private int offset;
        private int recordCount;
        private int stringTableSize;
        private int offsetRecordsEnd;
        private int idListSize;
        private int relationshipDataSize;
        private int offsetMapIdCount;
        private int copyTableCount;

        private int stringBlockPos;
        private int idBlockPos;
        private int copyBlockPos;
        private int copyBlockSize;
        private int indexBlockPos;
        private int indexBlockSize;
        private int relationshipDataPos;
        private int indexIdListPos;
        private int indexIdListSize;
        private int size;
        private boolean encrypted;
        private IntIntHashMap relationshipDataLookup;
    }

    private static class FieldMeta {
        private int bitShift;
        private int offset;


        private int valueLength;
        private int valueCount;
        private int type;
        private int size;
        private boolean signed;


        private int offsetBits;
        private int sizeBits;
        private int additionalDataSize;
        private int storageType;
        private int bitPackOffsetBits;
        private int blockOffset;
        private int bitPackSizeBits;
        private int arrayCount;

    }

    private static class ColumnMeta {
        //[FieldOffset(0)]
        private int bitOffset;
        //[FieldOffset(2)]
        private int bitSize;
        //[FieldOffset(4)]
        private int additionalDataSize;
        //[FieldOffset(8)]
        private int storageType;
        //[FieldOffset(12)]
        private int bitPackOffsetBits;
        private int bitPackSizeBits;
        private int arrayCount;


        private int size;
        private int type;
        private int offset;
        private int defaultValue;
        private int valueLength;
        private int valueCount;
        private int blockOffset;
        private boolean signed;

    }

    private static class OffsetMapEntry {
        private int offset;
        private int size;
    }

    private class Relationship {
        private int numEntries;
        private int minId;
        private int maxId;
        private IntIntHashMap entries;
    }

    private class Row {


        private byte[] data;

        int offset;
        int position;

        private int dataOffset;
        private int recordsOffset;
        private int refId;
        private boolean dataHasId;

        public int id;

        public Row(byte[] data, int recordsOffset, int offset, int id, int refId) {
            this.data = data;
            this.recordsOffset = recordsOffset;
            this.refId = refId;
            this.offset = offset;

            if (id != -1) {
                id = id;
            } else {
                int idFieldIndex = idField;
                id = 0;//GetFieldValue < int>(idFieldIndex);
                dataHasId = true;
            }
        }

        public Row(Row row) {
            this.data = row.data;
            this.recordsOffset = row.recordsOffset;
            this.refId = row.refId;
            this.offset = row.offset;
            this.id = row.id;
        }


        @SneakyThrows
        public T map() {
            Arrays.stream(domainClass.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Db2Field.class));
            T instance = (T) Utils.newInstance(domainClass);

            return instance;
        }
    }
}
