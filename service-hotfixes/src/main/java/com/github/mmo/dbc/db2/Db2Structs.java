package com.github.mmo.dbc.db2;

import lombok.AllArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


class Header {
    static final int HEADER_CAPACITY = 84;

    int signature;
    int recordCount;
    int fieldCount;
    int recordSize;
    int stringTableSize;
    int tableHash;
    int layoutHash;
    int minId;
    int maxId;
    int locale;
    int copyTableSize;
    short flags;
    short indexField;
    int totalFieldCount;
    int packedDataOffset;
    int parentLookupCount;
    int catalogDataOffset;
    int indexDataSize;
    int columnMetaSize;
    int commonDataSize;
    int palletDataSize;
    int parentLookupDataSize;
}


record FieldMetaData(short bits, short offset) {
}

class ColumnMetaData {
    short recordOffset;
    short size;
    int additionalDataSize;
    CompressionType compressionType;
    Immediate immediate;
    Pallet pallet;
    Common common;
}


record Immediate(int bitOffset, int bitWidth, int flags) {
}

record Pallet(int bitOffset, int bitWidth, int cardinality) {
}

record Common(Value32 defaultValue, int B, int C) {
}


enum CompressionType {
    None,
    Immediate,
    Common,
    Pallet,
    PalletArray,
    SignedImmediate;

    public static CompressionType get(int anInt) {
        return switch (anInt) {
            case 0 -> None;
            case 1 -> Immediate;
            case 2 -> Common;
            case 3 -> Pallet;
            case 4 -> PalletArray;
            case 5 -> SignedImmediate;
            default -> throw new IllegalStateException("Unexpected value: " + anInt);
        };
    }
}


@AllArgsConstructor
class ReferenceData {
    final int numRecords;
    final int minId;
    final int maxId;
    final Map<Integer, Integer> entries = new HashMap<>();
}

record SparseEntry(int offset, int size) {
}

class Value32 {
    final byte[] value = new byte[4];

    static Value32 from(int result) {
        Value32 value32 = new Value32();
        value32.value[3] = (byte) (result & 0xff);
        value32.value[2] = (byte) (result >>> 8 & 0xff);
        value32.value[1] = (byte) (result >>> 16 & 0xff);
        value32.value[0] = (byte) (result >>> 24 & 0xff);
        return value32;
    }
}

class Value64 {
    byte[] value = new byte[8];

    static Value64 from(long result) {
        Value64 value64 = new Value64();
        value64.value[7] = (byte) (result & 0xff);
        value64.value[6] = (byte) (result >>> 8 & 0xff);
        value64.value[5] = (byte) (result >>> 16 & 0xff);
        value64.value[4] = (byte) (result >>> 24 & 0xff);
        value64.value[3] = (byte) (result >>> 32 & 0xff);
        value64.value[2] = (byte) (result >>> 40 & 0xff);
        value64.value[1] = (byte) (result >>> 48 & 0xff);
        value64.value[0] = (byte) (result >>> 56 & 0xff);
        return value64;
    }
}

class RowData {
    private final ByteBuffer buffer;
    final int id;
    final Integer refID;
    final int recordIndex;

    private int readPos;
    private int readOffset;


    RowData(ByteBuffer data, int id, Integer refID, int recordIndex) {
        this.buffer = data;
        this.id = id;
        this.refID = refID;
        this.recordIndex = recordIndex;
    }

    int position() {
        return readPos;
    }


    void position(int position) {
        this.readPos = position;
    }


    int offset() {
        return readOffset;
    }

    void offset(int offset) {
        this.readOffset = offset;
    }

    int getUInt32(int numBits) {
        int index = readOffset + (readPos >> 3);
        int remaining = buffer.limit() - index;
        int b;
        if (remaining < 4) {
            byte[] result = new byte[4];
            IntStream.range(0, remaining).forEach(i -> result[remaining] = buffer.get(index + i));
            b = ByteBuffer.wrap(result).order(ByteOrder.LITTLE_ENDIAN).getInt();
        } else {
            b = buffer.getInt(index);
        }

        int result = b << (32 - numBits - (readPos & 7)) >>> (32 - numBits);
        readPos += numBits;
        return result;
    }

    long getUInt64(int numBits) {
        int index = readOffset + (readPos >> 3);
        int remaining = buffer.limit() - index;
        long b;
        if (remaining < 8) {
            byte[] result = new byte[8];
            IntStream.range(0, remaining).forEach(i -> result[remaining] = buffer.get(index + i));
            b = ByteBuffer.wrap(result).order(ByteOrder.LITTLE_ENDIAN).getLong();
        } else {
            b = buffer.getLong(index);
        }
        long result = b << (64 - numBits - (readPos & 7)) >>> (64 - numBits);
        readPos += numBits;
        return result;

    }

    Value64 getValue64(int numBits) {
        long l = getUInt64(numBits);
        return Value64.from(l);
    }

    Value64 getValue64Signed(int numBits) {
        long result = getUInt64(numBits);
        long signedShift = 1L << (numBits - 1);
        result = (signedShift ^ result) - signedShift;
        return Value64.from(result);
    }


    String getCString() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        long num;
        while ((num = getUInt32(8)) != 0) {
            stream.write((byte) num);
        }
        return stream.toString(StandardCharsets.UTF_8);
    }

}
