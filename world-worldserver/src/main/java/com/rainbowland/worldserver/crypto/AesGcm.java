package com.rainbowland.worldserver.crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Objects;


public class AesGcm {

    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";

    /**
     * 128 bits AES secret key
     */
    private static final int  KEY_BIT_LENGTH = 128;
    /**
     * The standard Initialization Vector (IV) length (96 bits).
     */
    private static final int IV_BIT_LENGTH = 96;

    /**
     * The standard authentication tag length (96 bits).
     */
    private static final int AUTH_TAG_BIT_LENGTH = 96;


    // AES-GCM needs GCMParameterSpec
    public static byte[] encrypt(byte[] key, byte[] iv, byte[] data, byte[] tag) throws Exception {
        validateInput(key, iv, data, tag);
        //In Java the tag is unfortunately added at the end of the ciphertext.
        // 128 bits AES secret key
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec,  new GCMParameterSpec(AUTH_TAG_BIT_LENGTH, iv));

        // Prepare output buffer
        int outputLength = cipher.getOutputSize(data.length);
        byte[] output = new byte[outputLength];

        int outputOffset  = cipher.update(data, 0, data.length, output, 0);

        outputOffset += cipher.doFinal(data, outputOffset);

        int authTagLength = AUTH_TAG_BIT_LENGTH / 8;
        // Split output into cipher text and authentication tag
        byte[] encryptedData = new byte[outputOffset - authTagLength];

        System.arraycopy(output, 0, encryptedData, 0, encryptedData.length);
        System.arraycopy(output, outputOffset - authTagLength, tag, 0, tag.length);
        return encryptedData;

    }



    public static byte[] decrypt(byte[] key, byte[] iv, byte[] data, byte[] tag) throws Exception {
        validateInput(key, iv, data, tag);
        // Join cipher text and authentication tag to produce cipher input
        byte[] input = new byte[data.length + tag.length];
        System.arraycopy(data, 0, input, 0, data.length);
        System.arraycopy(tag, 0, input, tag.length, tag.length);

        // 128 bits AES secret key
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, new GCMParameterSpec(AUTH_TAG_BIT_LENGTH, iv));
        return cipher.doFinal(input);
    }


    private static void validateInput(byte[] key, byte[] iv, byte[] data, byte[] tag) {
        Objects.requireNonNull(data);
        Objects.requireNonNull(tag);
        Objects.requireNonNull(iv);
        Objects.requireNonNull(key);
        if(key.length != KEY_BIT_LENGTH / 8) {
            throw new IllegalArgumentException();
        }
        if(iv.length != IV_BIT_LENGTH / 8) {
            throw new IllegalArgumentException();
        }
        if(tag.length != AUTH_TAG_BIT_LENGTH / 8) {
            throw new IllegalArgumentException();
        }
    }

}