package com.naveed.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import org.jasypt.properties.PropertyValueEncryptionUtils;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("jasypt");
        Properties props = new EncryptableProperties(encryptor);
        props.load(new FileInputStream("config.properties"));
        String password = props.getProperty("RPUSH.PASSWORD");
        String encryptedPassword = PropertyValueEncryptionUtils.encrypt(password, encryptor);
        String encrypt = encryptor.encrypt(password);
        System.out.println(">>>>>>>>>>>>> " + encryptor.decrypt(encrypt));
        System.out.println(">>>>>>>>>>>>> " + PropertyValueEncryptionUtils.decrypt(encryptedPassword, encryptor) + " " );
        System.out.println(">>>>>>>>>>>>>>>>>>>>> " + password + " >>>>>>>> " + encryptedPassword + " " + encrypt);
    }
}
