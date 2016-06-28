/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.io.IOException;
import java.io.PrintWriter;
import jline.console.ConsoleReader;
import jline.console.completer.ArgumentCompleter;
import jline.console.completer.StringsCompleter;

/**
 *
 * @author naveed
 */
public class Shell {

    private String[] commandsList;

    public void init() {
        commandsList = new String[]{"help", "action1", "action2", "exit"};
    }

    public void run() throws IOException {
        System.setProperty("jline.shutdownhook", "true");
        printWelcomeMessage();
        ConsoleReader console = new ConsoleReader();
        console.setBellEnabled(false);
        //completors.add();
        //reader.addCompletor(new StringsCompleter(completors));
        console.addCompleter(new ArgumentCompleter(new StringsCompleter(commandsList)));
        
        PrintWriter out = new PrintWriter(System.out);

        String line;
        while ((line = readLine(console, "")) != null) {
            if ("help".equals(line)) {
                printHelp();
            } else if ("action1".equals(line)) {
                System.out.println("You have selection action1");
            } else if ("action2".equals(line)) {
                System.out.println("You have selection action2");
            } else if ("exit".equals(line)) {
                System.out.println("Exiting application");
                return;
            } else {
                System.out.println("Invalid command, For assistance press TAB or type \"help\" then hit ENTER.");
            }
            out.flush();
        }
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to jLine Sample App. For assistance press TAB or type \"help\" then hit ENTER.");
    }

    private void printHelp() {
        System.out.println("help                - Show help");
        System.out.println("action1                - Execute action1");
        System.out.println("action2                - Execute action2");
        System.out.println("exit        - Exit the app");

    }

    private String readLine(ConsoleReader reader, String promtMessage)
            throws IOException {
        String line = reader.readLine(promtMessage + "\nshell> ");
        return line.trim();
    }

    public static void main(String[] args) throws IOException {
        Shell shell = new Shell();
        shell.init();
        shell.run();
    }
}
