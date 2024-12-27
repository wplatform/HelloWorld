package com.github.mmo.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

public class Compress {

    public static byte[] compress(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        byte[] buf = new byte[data.length];
        while (!deflater.finished()) {
            int i = deflater.deflate(buf);
            bos.write(buf, 0, i);
        }
        deflater.end();
        return bos.toByteArray();
    }

}
