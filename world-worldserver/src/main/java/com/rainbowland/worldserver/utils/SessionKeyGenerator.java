package com.rainbowland.worldserver.utils;

import com.rainbowland.utils.SecureUtils;

public class SessionKeyGenerator {

    private int o0it;
    private final byte[] o1;
    private final byte[] o2;
    private byte[] o0 = new byte[32];


    public SessionKeyGenerator(byte[] buff) {
        int halfSize = buff.length / 2;
        o1 = SecureUtils.sha256(buff, 0, halfSize);
        o2 = SecureUtils.sha256(buff, halfSize, buff.length - halfSize);
        o0 = SecureUtils.sha256(o1, o0, o2);
    }

    public void generate(byte[] buf) {
        for (int i = 0; i < buf.length; ++i) {
            if (o0it == o0.length) {
                o0 = SecureUtils.sha256(o1, o0, o2);
                o0it = 0;
            }
            buf[i] = o0[o0it++];
        }
    }


}
