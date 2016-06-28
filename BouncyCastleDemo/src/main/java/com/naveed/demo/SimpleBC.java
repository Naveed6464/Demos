/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.NoSuchProviderException;
import java.security.Security;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.examples.ByteArrayHandler;

/**
 *
 * @author nmrehman
 */
public class SimpleBC {

    private static String fileName = "testbc.txt";
    private static String passPhrase = "123";

    public static String decrypt() throws IOException, PGPException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());
        File encryptedFile = new File("test.txt.gpg");
        byte[] encryptedByteArray = FileUtils.readFileToByteArray(encryptedFile);

        byte[] decryptedByteArray = ByteArrayHandler.decrypt(encryptedByteArray, passPhrase.toCharArray());
        return new String(decryptedByteArray);
    }
    
    public static String decrypt(String encrypted) throws IOException, PGPException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());
        //File encryptedFile = new File("test.txt.gpg");
        //byte[] encryptedByteArray = FileUtils.readFileToByteArray(encryptedFile);
        byte[] decryptedByteArray = ByteArrayHandler.decrypt(encrypted.getBytes(), passPhrase.toCharArray());
        return new String(decryptedByteArray);
    }

    public static String encrypt(String text) throws IOException, PGPException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());        
        byte[] encrypted = ByteArrayHandler.encrypt(text.getBytes(), passPhrase.toCharArray(), fileName, SymmetricKeyAlgorithmTags.AES_256, true);
        String encryptedString = new String(encrypted);
        return encryptedString;
    }

    public static void setSize() {
        try {
            Field field = Class.forName("javax.crypto.JceSecurity").
                    getDeclaredField("isRestricted");
            field.setAccessible(true);
            field.set(null, java.lang.Boolean.FALSE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, PGPException, NoSuchProviderException {
        setSize();
        String textToEncrypt = "This is a string";
        String encrypt = encrypt(textToEncrypt);
        System.out.println("Encrypted String " + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("Decrypted String " + decrypt);
    }
}
