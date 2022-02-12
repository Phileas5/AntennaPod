package com.antennapod.encrypter;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncrypterTest {

    @Test
    public void testCryptOffset1() {
        String encryptedString = Encrypter.crypt(1, "abc");
        assertEquals("bcd", encryptedString);
    }

    @Test
    public void testCryptLoop() {
        String encryptedString = Encrypter.crypt(25, "abc");
        assertEquals("abc", encryptedString);
    }

    @Test
    public void testCryptSentence() {
        String encryptedString = Encrypter.crypt(14, "je suis un ami de la famille");
        assertEquals("xs hjwh jc obw rs ao tobwaas", encryptedString);
    }

    @Test
    public void testDecrypt() {
        String decryptedString = Encrypter.decrypt(1, "cde");
        assertEquals("bcd", decryptedString);
    }
}