package com.github.mmo.dbc.db2;


import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.Locale;
import com.github.mmo.exeception.ValueOverflowException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
public class Db2EntityReader<T extends DbcEntity> {


    private final FileChannel fileChannel;

    final Db2DataBinder<T> db2DataBinder;

    final Header header = new Header();
    FieldMetaData[] db2Fields;
    ColumnMetaData[] columnMeta;

    Value32[][] palletData;
    Map<Integer, Value32>[] commonData;

    int[] indexData;

    long dataPos;
    ByteBuffer data;
    ByteBuffer stringTable;

    List<SparseEntry> sparseEntries;
    Map<Integer, Integer> copyData;
    ReferenceData refData = null;


    private Db2EntityReader(FileChannel fileChannel, Db2DataBinder<T> db2DataBinder) {
        this.fileChannel = fileChannel;
        this.db2DataBinder = db2DataBinder;
    }

    public static <T extends DbcEntity> Stream<T> read(String dataFolder, Locale locale, Class<T> clazz) {
        final Db2DataBinder<T> db2DataBinder = new Db2DataBinder<>(clazz);
        Path db2FilePath = Paths.get(dataFolder, "dbc", locale.name(), db2DataBinder.name());
        try (FileChannel fileChannel = FileChannel.open(db2FilePath, StandardOpenOption.READ)) {
            Db2EntityReader<T> instance = new Db2EntityReader<>(fileChannel, db2DataBinder);
            instance.read(db2FilePath);
            Db2EntityIterator<T> db2EntityIterator = new Db2EntityIterator<>(locale, db2DataBinder, instance);
            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(db2EntityIterator, Spliterator.ORDERED | Spliterator.NONNULL), false);
        } catch (IOException e) {
            log.error("Read the db2 file {} occurred IO error.", db2FilePath.toAbsolutePath(), e);
            throw new RuntimeException("Read ", e);
        }
    }


    private void readHeader(Path db2FilePath) throws IOException {
        System.out.println(fileChannel.size());
        ByteBuffer buffer = ByteBuffer.allocate(Header.HEADER_CAPACITY);
        fileChannel.read(buffer);
        buffer.order(ByteOrder.LITTLE_ENDIAN).flip();

        header.signature = buffer.getInt();
        header.recordCount = buffer.getInt();
        header.fieldCount = buffer.getInt();
        header.recordSize = buffer.getInt();
        header.stringTableSize = buffer.getInt();
        header.tableHash = buffer.getInt();
        header.layoutHash = buffer.getInt();
        header.minId = buffer.getInt();
        header.maxId = buffer.getInt();
        header.locale = buffer.getInt();
        header.copyTableSize = buffer.getInt();
        header.flags = buffer.getShort();
        header.indexField = buffer.getShort();
        header.totalFieldCount = buffer.getInt();
        header.packedDataOffset = buffer.getInt();
        header.parentLookupCount = buffer.getInt();
        header.catalogDataOffset = buffer.getInt();
        header.indexDataSize = buffer.getInt();
        header.columnMetaSize = buffer.getInt();
        header.commonDataSize = buffer.getInt();
        header.palletDataSize = buffer.getInt();
        header.parentLookupDataSize = buffer.getInt();

        if (header.recordCount == 0)
            return;

        //'WDC1'
        if (header.signature != 0x31434457) {
            throw new DB2FileException("Incorrect file signature in %s, expected 'WDC1', got %c%c%c%c".formatted(
                    db2FilePath.toAbsolutePath(), (char) (header.signature & 0xFF), (char) ((header.signature >> 8) & 0xFF), (char) ((header.signature >> 16) & 0xFF), (char) ((header.signature >> 24) & 0xFF)
            ));
        }

        if (header.layoutHash != db2DataBinder.layoutHash())
            throw new DB2FileException("Incorrect layout hash in %s, expected 0x%08X, got 0x%08X (possibly wrong client version)".formatted(db2FilePath.toAbsolutePath(), db2DataBinder.layoutHash(), header.layoutHash));


        if ((header.flags & 0x1) == 0) {
            int expectedFileSize = Header.HEADER_CAPACITY +
                    (4 * header.fieldCount) +
                    header.recordCount * header.recordSize +
                    header.stringTableSize +
                    header.indexDataSize +
                    header.copyTableSize +
                    header.columnMetaSize +
                    header.palletDataSize +
                    header.commonDataSize +
                    header.parentLookupDataSize;

            if (fileChannel.size() != expectedFileSize)
                throw new DB2FileException("%s failed size consistency check, expected %d, got %d".formatted(db2FilePath.toAbsolutePath(), expectedFileSize, fileChannel.size()));
        }


        if (header.parentLookupCount > 1)
            throw new DB2FileException("Too many parent lookups in %s, only one is allowed, got %d".formatted(db2FilePath.toAbsolutePath(), header.parentLookupCount));


        if ((header.parentLookupCount > 0 && !db2DataBinder.hasParentIndexField()))
            throw new DB2FileException("Unexpected parent lookup found in %s".formatted(db2FilePath.toAbsolutePath()));


        int totalFieldCount = header.totalFieldCount + ((db2DataBinder.parentIndexField() >= header.totalFieldCount) ? 1 : 0);
        if (totalFieldCount != db2DataBinder.fieldCount())
            throw new DB2FileException("Incorrect number of fields in %s, expected %d, got %d".formatted(db2FilePath.toAbsolutePath(), db2DataBinder.fieldCount(), totalFieldCount));

        if ((header.parentLookupCount > 0 && db2DataBinder.parentIndexField() == -1))
            throw new DB2FileException("Unexpected parent lookup found in %s".formatted(db2FilePath.toAbsolutePath()));

    }


    void read(Path db2FilePath) throws IOException {

        readHeader(db2FilePath);

        ByteBuffer buffer = ByteBuffer.allocate(header.fieldCount * 4);
        fileChannel.read(buffer);
        buffer.order(ByteOrder.LITTLE_ENDIAN).flip();
        db2Fields = new FieldMetaData[header.fieldCount];
        ByteBuffer finalBuffer = buffer;
        IntStream.range(0, db2Fields.length).forEach(i -> db2Fields[i] = new FieldMetaData(finalBuffer.getShort(), finalBuffer.getShort()));

        if ((header.flags & 0x1) == 0) {
            data = ByteBuffer.allocate(header.recordSize * header.recordCount);
            stringTable = ByteBuffer.allocate(header.stringTableSize);
            fileChannel.read(data);
            fileChannel.read(stringTable);
            data.order(ByteOrder.LITTLE_ENDIAN).flip();
            stringTable.flip();
        } else {
            dataPos = fileChannel.position();
            data = ByteBuffer.allocate(header.catalogDataOffset - (int) dataPos);
            fileChannel.read(data);
            data.order(ByteOrder.LITTLE_ENDIAN).flip();

            int sparseCount = header.maxId - header.minId + 1;
            sparseEntries = new ArrayList<>(sparseCount);
            copyData = HashMap.newHashMap(sparseCount);
            Map<Integer, Integer> sparseIdLookup = HashMap.newHashMap(sparseCount);
            buffer = ByteBuffer.allocate(sparseCount * 6);
            fileChannel.read(buffer);
            buffer.order(ByteOrder.LITTLE_ENDIAN).flip();

            for (int i = 0; i < sparseCount; i++) {
                SparseEntry sparse = new SparseEntry(buffer.getInt(), buffer.getShort());
                if (sparse.offset() == 0 || sparse.size() == 0)
                    continue;

                Integer copyId = sparseIdLookup.get(sparse.offset());
                if (copyId != null) {
                    copyData.put(header.minId + i, copyId);
                } else {
                    sparseEntries.add(sparse);
                    sparseIdLookup.put(sparse.offset(), header.minId + i);
                }
            }
        }

        if (db2DataBinder.hasIndexField()) {
            if (header.indexDataSize != 0)
                throw new DB2FileException("Unexpected id table found in %s".formatted(db2FilePath.toAbsolutePath()));
        } else if (header.indexDataSize != 4 * header.recordCount) {
            throw new DB2FileException("Unexpected id table size in %s, expected %d, got %d".formatted(db2FilePath.toAbsolutePath(), header.recordCount, header.indexDataSize));
        }

        // index data
        indexData = new int[header.indexDataSize / 4];
        buffer = ByteBuffer.allocate(header.indexDataSize);
        fileChannel.read(buffer);
        buffer.order(ByteOrder.LITTLE_ENDIAN).flip().asIntBuffer().get(indexData);

        // duplicate rows data
        if (header.copyTableSize > 0) {
            copyData = HashMap.newHashMap(header.copyTableSize / 8);
            buffer = ByteBuffer.allocate(header.copyTableSize);
            fileChannel.read(buffer);
            buffer.order(ByteOrder.LITTLE_ENDIAN).flip();

            for (int i = 0; i < header.copyTableSize / 8; i++) {
                copyData.put(buffer.getInt(), buffer.getInt());
            }
        }

        // column meta data
        if (header.columnMetaSize > 0) {
            columnMeta = new ColumnMetaData[header.totalFieldCount];
            buffer = ByteBuffer.allocate(header.columnMetaSize);
            fileChannel.read(buffer);
            buffer.order(ByteOrder.LITTLE_ENDIAN).flip();
            for (int i = 0; i < columnMeta.length; i++) {
                columnMeta[i] = new ColumnMetaData();
                columnMeta[i] = new ColumnMetaData();
                columnMeta[i].recordOffset = buffer.getShort();
                columnMeta[i].size = buffer.getShort();
                columnMeta[i].additionalDataSize = buffer.getInt();
                columnMeta[i].compressionType = CompressionType.get(buffer.getInt());

                if (columnMeta[i].recordOffset < 0) {
                    throw new ValueOverflowException("columnMeta[" + i + "].fieldOffsetBits:" + columnMeta[i].recordOffset);
                }
                if (columnMeta[i].size < 0) {
                    throw new ValueOverflowException("columnMeta[" + i + "].fieldSizeBits:" + columnMeta[i].size);
                }
                if (columnMeta[i].additionalDataSize < 0) {
                    throw new ValueOverflowException("columnMeta[" + i + "].additionalDataSize:" + columnMeta[i].additionalDataSize);
                }

                switch (columnMeta[i].compressionType) {
                    case None, Immediate, SignedImmediate ->
                            columnMeta[i].immediate = new Immediate(buffer.getInt(), buffer.getInt(), buffer.getInt());
                    case Common -> {
                        Value32 value32 = new Value32();
                        buffer.get(value32.value);
                        columnMeta[i].common = new Common(value32, buffer.getInt(), buffer.getInt());
                    }
                    case Pallet, PalletArray ->
                            columnMeta[i].pallet = new Pallet(buffer.getInt(), buffer.getInt(), buffer.getInt());
                }
            }

            if (db2DataBinder.hasIndexField()) {
                CompressionType compressionType = columnMeta[db2DataBinder.indexField()].compressionType;
                if (compressionType != CompressionType.None
                        && compressionType != CompressionType.Immediate
                        && compressionType != CompressionType.SignedImmediate)
                    throw new DB2FileException(("Invalid compression type for index field in %s, expected one of None (0), Immediate (1), " +
                            "SignedImmediate (5), got %s").formatted(db2FilePath.toAbsolutePath(), compressionType));
            }

            // pallet data
            palletData = new Value32[header.totalFieldCount][];
            for (int i = 0; i < palletData.length; i++) {
                if (columnMeta[i].compressionType == CompressionType.Pallet || columnMeta[i].compressionType == CompressionType.PalletArray) {
                    buffer = ByteBuffer.allocate(columnMeta[i].additionalDataSize);
                    fileChannel.read(buffer);
                    buffer.order(ByteOrder.LITTLE_ENDIAN).flip();
                    palletData[i] = new Value32[columnMeta[i].additionalDataSize / 4];
                    for (int j = 0; j < palletData[i].length; j++) {
                        palletData[i][j] = Value32.from(buffer.getInt());
                    }

                }
            }

            // common data
            commonData = new Map[columnMeta.length];
            for (int i = 0; i < columnMeta.length; i++) {
                if (columnMeta[i].compressionType == CompressionType.Common) {
                    buffer = ByteBuffer.allocate(columnMeta[i].additionalDataSize);
                    fileChannel.read(buffer);
                    buffer.order(ByteOrder.LITTLE_ENDIAN).flip();
                    commonData[i] = HashMap.newHashMap(columnMeta[i].additionalDataSize / 8);
                    for (int j = 0; j < columnMeta[i].additionalDataSize / 8; j++) {
                        commonData[i].put(buffer.getInt(), Value32.from(buffer.getInt()));
                    }

                }
            }

            // reference data
            if (header.parentLookupDataSize > 0) {
                buffer = ByteBuffer.allocate(12);
                fileChannel.read(buffer);
                buffer.order(ByteOrder.LITTLE_ENDIAN).flip();
                refData = new ReferenceData(buffer.getInt(), buffer.getInt(), buffer.getInt());

                buffer = ByteBuffer.allocate(8 * refData.numRecords);
                fileChannel.read(buffer);
                buffer.order(ByteOrder.LITTLE_ENDIAN).flip();

                for (int i = 0; i < refData.numRecords; i++) {
                    int id = buffer.getInt();
                    int index = buffer.getInt();
                    refData.entries.put(index, id);
                }
            }
        }
    }
}

