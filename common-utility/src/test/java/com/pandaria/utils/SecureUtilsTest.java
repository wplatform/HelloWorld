package com.pandaria.utils;

import com.github.mmo.utils.SecureUtils;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

class SecureUtilsTest {

    @Test
    void passwordHash() {

        byte[] bytes = SecureUtils.sha256("TEST".getBytes(StandardCharsets.UTF_8));
        String userHexString = SecureUtils.bytesToHexString(bytes);
        bytes = SecureUtils.sha256(userHexString.getBytes(), ":".getBytes(StandardCharsets.UTF_8), "TEST".getBytes(StandardCharsets.UTF_8));
        System.out.println(SecureUtils.bytesToHexString(bytes));
    }
}