/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jline.console.ConsoleReader;
import jline.console.completer.Completer;
import jline.console.completer.StringsCompleter;

/**
 *
 * @author naveed
 */
public class AbstractShell implements IShell {

    ConsoleReader console;
    private String helpMessage;
    private String bannerText;

    public AbstractShell() {
        try {
            console = new ConsoleReader();
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
    }

    @Override
    public void setPrompt(String prompt) {
        console.setPrompt("\u001B[1m" + prompt + "\u001B[0m");
    }

    @Override
    public void setBannerText(String text) {
        this.bannerText = text;
    }

    @Override
    public void addCommands(String[] commands) {
        console.addCompleter(new StringsCompleter(commands));
    }

    @Override
    public void addCompleter(Completer completer) {
        console.addCompleter(completer);
    }

    @Override
    public void addCompleters(List<Completer> completers) {
        for (Completer completer : completers) {
            console.addCompleter(completer);
        }
    }

    @Override
    public void setHelpMessage(String msg) {
        this.helpMessage = msg;
    }

    public void printHelpMessage() {
        try {
            console.println(helpMessage);
        } catch (IOException ex) {
            Logger.getLogger(AbstractShell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void promptLoop() {
        System.setProperty("jline.shutdownhook", "true");        
        try {
            console.println("\u001B[32m" + bannerText + "\u001B[0m");
            String line;
            End:
            while ((line = console.readLine().trim()) != null) {
                switch (line) {
                    case "print":
                        console.printColumns(Arrays.asList("Line 1" , "Line 2" , "Line 3", "Line 4"));
                        break;
                    case "test":
                        console.moveCursor(5);
                        break;
                    case "exit":
                    case "quite":
                        break End;
                    case "help":
                        printHelpMessage();
                        break;
                    case "color":
                        console.println("\u001B[33m======>\u001B[0m\"" + line + "\"");
                        break;
                    default:
                        //System.out.println("Invalid command, For assistance press TAB or type \"help\" then hit ENTER.");
                        console.println("Def: " + line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AbstractShell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CommandResult executeCommand(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
