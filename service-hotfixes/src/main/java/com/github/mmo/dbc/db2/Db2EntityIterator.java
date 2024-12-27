package com.github.mmo.dbc.db2;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.Locale;
import com.github.mmo.exeception.ValueOverflowException;
import com.github.mmo.utils.FuryUtil;


import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;


class Db2EntityIterator<T extends DbcEntity> implements Iterator<T> {

    private final Db2DataBinder<T> db2DataBinder;

    private final Locale locale;

    private final Db2EntityReader<T> reader;

    private int index;
    private int position = 0;
    private RowData currentData;
    private final Map<Integer, T> copyEntity = new LinkedHashMap<>();
    private Iterator<Map.Entry<Integer, Integer>> copyEnityiterator;


    Db2EntityIterator(Locale locale, Db2DataBinder<T> db2DataBinder, Db2EntityReader<T> db2EntityReader) {
        this.locale = locale;
        this.db2DataBinder = db2DataBinder;
        this.reader = db2EntityReader;
    }


    @Override
    public boolean hasNext() {
        if (index < reader.header.recordCount) {
            Integer refId = reader.refData != null ? reader.refData.entries.get(index) : null;
            RowData rowData = new RowData(reader.data, reader.header.indexDataSize != 0 ? reader.indexData[index] : -1, refId, index);

            if ((reader.header.flags & 0x1) == 0x1) {
                rowData.position(position);
                position += reader.sparseEntries.get(index).size() * 8;
            } else {
                rowData.offset(index * reader.header.recordSize);
            }
            this.currentData = rowData;
            return true;
        } else if (copyEnityiterator != null) {
            return copyEnityiterator.hasNext();
        } else if (reader.copyData != null) {
            reader.copyData.entrySet().iterator();
            copyEnityiterator = reader.copyData.entrySet().iterator();
            return copyEnityiterator.hasNext();
        }
        return false;
    }

    @Override
    public T next() {
        if (index++ < reader.header.recordCount) {
            return toEntity(currentData);
        } else {
            Map.Entry<Integer, Integer> next = copyEnityiterator.next();
            T source = copyEntity.get(next.getValue());
            T copied = FuryUtil.copy(source);
            copied.setId(next.getKey());
            return copied;
        }
    }


    private T toEntity(RowData rowData) {

        T entity = db2DataBinder.newInstance();
        entity.setId(rowData.id != -1 ? rowData.id : null);

        IntStream.range(0, db2DataBinder.fieldCount()).forEach(i -> {

            Db2Field fieldMeta = db2DataBinder.fieldAt(i);

            if (i >= reader.columnMeta.length) {
                Db2Field parentField = db2DataBinder.fieldAt(db2DataBinder.parentIndexField());
                db2DataBinder.bind(parentField.name()[0], rowData.refID);
                return;
            }

            if (db2DataBinder.isArray(i)) {
                Object[] value = switch (fieldMeta.type()) {
                    case INT ->
                            fieldMeta.signed() ? getInt32ValueArray(rowData, i, db2DataBinder.arraySize(i)) : getUInt32ValueArray(rowData, i, db2DataBinder.arraySize(i));
                    case SHORT ->
                            fieldMeta.signed() ? getInt16ValueArray(rowData, i, db2DataBinder.arraySize(i)) : getUInt16ValueArray(rowData, i, db2DataBinder.arraySize(i));
                    case BYTE ->
                            fieldMeta.signed() ? getInt8ValueArray(rowData, i, db2DataBinder.arraySize(i)) : getUInt8ValueArray(rowData, i, db2DataBinder.arraySize(i));
                    case LONG ->
                            fieldMeta.signed() ? getInt64ValueArray(rowData, i, db2DataBinder.arraySize(i)) : getUInt64ValueArray(rowData, i, db2DataBinder.arraySize(i));
                    case FLOAT -> getFloatValueArray(rowData, i, db2DataBinder.arraySize(i));
                    case STRING, STRING_NOT_LOCALIZED -> getStringValueArray(rowData, i, db2DataBinder.arraySize(i));
                };

                if (fieldMeta.type() == Db2Type.STRING) {
                    IntStream.range(0, value.length).forEach(v -> db2DataBinder.bindLocalizedString(fieldMeta.name()[v], locale, value[v].toString()));
                } else {
                    IntStream.range(0, value.length).forEach(v -> db2DataBinder.bind(fieldMeta.name()[v], value[v]));
                }
            } else {
                String fieldName = fieldMeta.name()[0];
                Object fieldValue = switch (fieldMeta.type()) {
                    case STRING, STRING_NOT_LOCALIZED -> getString(entity.getId(), rowData, i);
                    case INT ->
                            fieldMeta.signed() ? getInt32(entity.getId(), rowData, i) : getUInt32(entity.getId(), rowData, i);
                    case SHORT ->
                            fieldMeta.signed() ? getInt16(entity.getId(), rowData, i) : getUInt16(entity.getId(), rowData, i);
                    case BYTE ->
                            fieldMeta.signed() ? getInt8(entity.getId(), rowData, i) : getUInt8(entity.getId(), rowData, i);
                    case LONG ->
                            fieldMeta.signed() ? getInt64(entity.getId(), rowData, i) : getUInt64(entity.getId(), rowData, i);
                    case FLOAT -> getFloat(entity.getId(), rowData, i);
                };
                if (fieldMeta.type() == Db2Type.STRING) {
                    db2DataBinder.bindLocalizedString(fieldName, locale, fieldValue.toString());
                } else {
                    db2DataBinder.bind(fieldName, fieldValue);
                }
            }
        });


        Integer id = entity.getId();
        if (reader.copyData != null) {
            if (reader.copyData.containsValue(id)) {
                copyEntity.put(id, entity);
            }
        }
        return entity;
    }

    Byte getInt8(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        return fieldVal.byteValue();
    }

    Short getUInt8(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        byte b = fieldVal.byteValue();
        return (short) ((short)b & 0xff);
    }

    Short getInt16(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        return fieldVal.shortValue();
    }

    Integer getUInt16(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        short shortValue = fieldVal.shortValue();
        return  (shortValue & 0xffff);
    }

    Integer getUInt32(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        int intValue = fieldVal.intValue();
        if (intValue < 0) {
            throw new ValueOverflowException("Unsigned int property %s %d in %s is overflowed.".formatted(db2DataBinder.fieldAt(fieldIndex).name()[0], intValue, db2DataBinder.getEntityClass()));
        }
        return intValue;
    }

    Integer getInt32(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        return fieldVal.intValue();
    }

    BigInteger getUInt64(Integer id, RowData rowData, int fieldIndex) {
        return getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
    }

    Long getInt64(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        return fieldVal.longValue();
    }

    Float getFloat(Integer id, RowData rowData, int fieldIndex) {
        BigInteger fieldVal = getFieldValue(id, rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], reader.commonData[fieldIndex]);
        return fieldVal.floatValue();
    }

    String getString(Integer id, RowData rowData, int fieldIndex) {
        if ((reader.header.flags & 0x1) == 0x1) {
            return rowData.getCString();
        } else {
            int stringOffset = getInt32(id, rowData, fieldIndex);
            return getCStringFromStringTable(stringOffset);
        }
    }

    Byte[] getInt8ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(Number::byteValue).toArray(Byte[]::new);
    }

    Short[] getUInt8ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(e -> (short)((short)e.byteValue() & 0xff)).toArray(Short[]::new);
    }

    Short[] getInt16ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(Number::shortValue).toArray(Short[]::new);
    }

    Integer[] getUInt16ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(e->e.shortValue() & 0xffff).toArray(Integer[]::new);
    }

    Integer[] getUInt32ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(e -> {
            int intValue = e.intValue();
            if (intValue < 0) {
                throw new ValueOverflowException("Unsigned int property %s %d in %s is overflowed.".formatted(Arrays.toString(db2DataBinder.fieldAt(fieldIndex).name()), intValue, db2DataBinder.getEntityClass()));
            }
            return intValue;
        }).toArray(Integer[]::new);
    }

    Integer[] getInt32ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(Number::intValue).toArray(Integer[]::new);
    }

    Long[] getInt64ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(Number::longValue).toArray(Long[]::new);
    }

    BigInteger[] getUInt64ValueArray(RowData rowData, int fieldIndex, int arraySize) {
        return getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
    }

    Float[] getFloatValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(Number::floatValue).toArray(Float[]::new);
    }

    String[] getStringValueArray(RowData rowData, int fieldIndex, int arraySize) {
        BigInteger[] fieldVals = getFieldValueArray(rowData, reader.db2Fields[fieldIndex], reader.columnMeta[fieldIndex], reader.palletData[fieldIndex], arraySize);
        return Arrays.stream(fieldVals).map(e -> getCStringFromStringTable(e.intValue())).toArray(String[]::new);
    }

    private static BigInteger getFieldValue(Integer id, RowData r, FieldMetaData fieldMeta, ColumnMetaData columnMeta, Value32[] palletData, Map<Integer, Value32> commonData) {
        switch (columnMeta.compressionType) {
            case CompressionType.None -> {
                int bitSize = 32 - fieldMeta.bits();
                if (bitSize <= 0)
                    bitSize = columnMeta.immediate.bitWidth();

                return new BigInteger(1, r.getValue64(bitSize).value);
            }
            case CompressionType.Immediate -> {
                if ((columnMeta.immediate.flags() & 0x1) == 0x1)
                    return new BigInteger(r.getValue64Signed(columnMeta.immediate.bitWidth()).value);
                return new BigInteger(r.getValue64(columnMeta.immediate.bitWidth()).value);
            }
            case CompressionType.Common -> {
                Value32 val = commonData.get(id);
                if (val != null)
                    return new BigInteger(1, val.value);
                return new BigInteger(1, columnMeta.common.defaultValue().value);
            }
            case CompressionType.Pallet -> {
                long index = r.getUInt32(columnMeta.pallet.bitWidth());
                return new BigInteger(palletData[(int) index].value);
            }
            case CompressionType.PalletArray -> {
                if (columnMeta.pallet.cardinality() != 1)
                    break;
                long palletArrayIndex = r.getUInt32(columnMeta.pallet.bitWidth());
                return new BigInteger(1, palletData[(int) palletArrayIndex].value);
            }
        }
        throw new IllegalStateException("Unexpected compression type " + columnMeta.compressionType);
    }


    private static BigInteger[] getFieldValueArray(RowData r, FieldMetaData fieldMeta, ColumnMetaData columnMeta, Value32[] palletData, int arraySize) {
        BigInteger[] array;
        switch (columnMeta.compressionType) {
            case CompressionType.None: {
                int bitSize = 32 - fieldMeta.bits();
                if (bitSize <= 0)
                    bitSize = columnMeta.immediate.bitWidth();

                array = new BigInteger[arraySize];

                for (int i = 0; i < array.length; i++)
                    array[i] = new BigInteger(r.getValue64(bitSize).value);

                return array;
            }
            case CompressionType.PalletArray: {
                int cardinality = columnMeta.pallet.cardinality();
                long palletArrayIndex = r.getUInt32(columnMeta.pallet.bitWidth());

                array = new BigInteger[cardinality];
                for (int i = 0; i < array.length; i++)
                    array[i] = new BigInteger(palletData[i + cardinality * (int) palletArrayIndex].value);

                return array;

            }
        }
        throw new IllegalStateException("Unexpected compression type " + columnMeta.compressionType);
    }

    private String getCStringFromStringTable(int stringOffset) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        while (true) {
            byte b = reader.stringTable.get(stringOffset++);
            if (b == '\0') {
                break;
            }
            data.write(b);
        }
        return data.toString(StandardCharsets.UTF_8);
    }
}
