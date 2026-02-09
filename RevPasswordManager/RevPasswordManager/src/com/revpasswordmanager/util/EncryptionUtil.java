package com.revpasswordmanager.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

public class EncryptionUtil {

    // FIXED AES KEY (for demo project)
    private static final String SECRET = "RevPasswordKey12";
    private static final SecretKeySpec key =
            new SecretKeySpec(SECRET.getBytes(), "AES");

    // =========================
    // MASTER PASSWORD (HASHING)
    // =========================
    public static String hash(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return Base64.getEncoder().encodeToString(md.digest(input.getBytes()));
    }

    public static boolean verify(String inputPassword, String storedHash) throws Exception {
        return hash(inputPassword).equals(storedHash);
    }

    // =========================
    // ACCOUNT PASSWORDS (AES)
    // =========================
    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
    }
}
