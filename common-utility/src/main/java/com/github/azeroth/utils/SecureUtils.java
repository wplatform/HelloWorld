package com.github.azeroth.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.stream.IntStream;

public class SecureUtils {



    public static String bytesToHexString(byte[] src) {
        Objects.requireNonNull(src);
        StringBuilder stringBuilder = new StringBuilder(src.length * 2);
        IntStream.range(0, src.length).map(i -> src[i] & 0xFF).mapToObj(Integer::toHexString).forEach(hv -> {
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        });
        return stringBuilder.toString();
    }

    public static byte[] hexStringToByteArray(String hexString) {
        Objects.requireNonNull(hexString);
        if ((hexString.length() & 1) == 1) {
            throw new IllegalArgumentException("hexString must have even number of character");
        }

        byte[] result = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            result[i / 2] = (byte) Integer.parseInt(hexString.substring(i, i + 2), 16);
        }
        return result;
    }



    public static byte[] sha256(byte[] source, int offset, int length) {
        Objects.requireNonNull(source);
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(source, offset, length);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }

    }


    public static byte[] sha256(byte[]... sources) {
        Objects.requireNonNull(sources);
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            for (byte[] src : sources) {
                messageDigest.update(src);
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }

    }

    public static byte[] hmacSHA256(byte[] key, byte[]... sources) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key, "HmacSHA256");
            sha256_HMAC.init(secret_key);
            for (byte[] src : sources) {
                sha256_HMAC.update(src);
            }
            return sha256_HMAC.doFinal();
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }


    public static String passwordHash(String userName, String password) {
        Objects.requireNonNull(userName);
        Objects.requireNonNull(password);
        userName = userName.toLowerCase();
        byte[] bytes = sha256(userName.getBytes(StandardCharsets.UTF_8));
        String userHexString = bytesToHexString(bytes);
        bytes = sha256(userHexString.getBytes(), password.getBytes(StandardCharsets.UTF_8));
        return bytesToHexString(bytes);
    }

}
