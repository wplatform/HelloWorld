package com.rainbowland.worldserver.crypto;

import com.rainbowland.worldserver.constant.Constants;
import lombok.SneakyThrows;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Rsa {


    @SneakyThrows
    public static PublicKey getPublicKey(String base64PublicKey) {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    @SneakyThrows
    public static PrivateKey getPrivateKey(String base64PrivateKey) {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    @SneakyThrows
    public static byte[] decrypt(byte[] data) {
        PrivateKey privateKey = getPrivateKey(Constants.RSA_PRIVATE_KEY);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    @SneakyThrows
    public static byte[] sign(byte[] data) {
        PrivateKey privateKey = getPrivateKey(Constants.RSA_PRIVATE_KEY);
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(data);
        return privateSignature.sign();
    }

    public static boolean verify(byte[] plain, byte[] signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(plain);

        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        return publicSignature.verify(signatureBytes);
    }


}
