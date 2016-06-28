/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.io.IOException;
import jline.console.ConsoleReader;

/**
 *
 * @author nmrehman
 */
public class PasswordReader {

    public static void usage() {
        System.out.println("Usage: java "
                + PasswordReader.class.getName() + " [mask]");
    }

    public static void main(String[] args) throws IOException {
        ConsoleReader reader = new ConsoleReader();
        Character mask = (args.length == 0)
                ? new Character((char) 0)
                : new Character(args[0].charAt(0));
        String line;
        do {
            line = reader.readLine("Enter password> ", mask);
            System.out.println("Got password: " + line);
        } while (line != null && line.length() > 0);
    }

}
