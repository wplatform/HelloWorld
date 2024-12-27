package com.pandaria.utils;

import com.github.mmo.utils.Compress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

class CompressTest {

    @Test
    public void compress() {
        String value = "JSONRealmListServerIPAddresses:{\"test\":\"test\"}\0";
        byte[] valueBytes = value.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < valueBytes.length; i++) {
            System.out.printf("%02X ",valueBytes[i]);
        }
        System.out.println();


        byte[] compressed = Compress.compress(valueBytes);
        byte[] compressedWithLength = new byte[compressed.length + 4];

        //Data is always little endian in c
        ByteBuffer.wrap(compressedWithLength).order(ByteOrder.LITTLE_ENDIAN).putInt(valueBytes.length).put(compressed);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < compressedWithLength.length; i++) {
            stringBuilder.append(String.format("%02X ",compressedWithLength[i]));
        }

        Assertions.assertTrue("2F 00 00 00 78 9C F3 0A F6 F7 0B 4A 4D CC C9 F5 C9 2C 2E 09 4E 2D 2A 4B 2D F2 0C 70 4C 49 29 4A 2D 2E 4E 2D B6 AA 56 2A 49 2D 2E 51 B2 82 50 B5 0C 00 A1 15 10 EA ".equals(stringBuilder.toString()));
    }
}