package com.naveed.demo;

import java.io.IOException;
import java.util.Arrays;
import jline.console.ConsoleReader;
import jline.console.completer.ArgumentCompleter;
import jline.console.completer.StringsCompleter;

/**
 *
 * @author naveed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractShell shell = new AbstractShell();
        shell.setPrompt("prompt> ");
        shell.setBannerText("Naveedur Rahman!");
        String[] commandsList = new String[]{"help", "action1", "action2 default", "exit"};
        shell.addCommands(commandsList);
        shell.addCompleter(new ArgumentOptionCompleter(Arrays.asList("--third", "--fourth"), "commandname"));
        shell.addCompleter(new ArgumentOptionCompleter(Arrays.asList("--fifth", "--sixth"), "demo"));
        shell.promptLoop();
    }

    public void run() {
        System.setProperty("jline.shutdownhook", "true");
        printWelcomeMessage();
        try {
            ConsoleReader console = new ConsoleReader();
            console.setPrompt("prompt> ");
            String[] commandsList = new String[]{"help", "action1 ", "action2 default", "exit"};

            console.addCompleter(new StringsCompleter(commandsList));

            console.setPrompt("\u001B[1mfoo\u001B[0m@bar\u001B[32m@baz\u001B[0m> ");
            console.addCompleter(new ArgumentCompleter(new StringsCompleter("foo", "bar", "baz")));
            console.addCompleter(new ArgumentOptionCompleter(Arrays.asList("--third", "--fourth"), "commandname"));
            console.addCompleter(new ArgumentOptionCompleter(Arrays.asList("--fifth", "--sixth"), "demo"));
            String line;
            End:
            while ((line = console.readLine().trim()) != null) {
                switch (line) {
                    case "print":
                        console.printColumns(Arrays.asList("Line 1" , "Line 2" , "Line 3", "Line 4"));
                        break;
                    case "test":
                        break;
                    case "exit":
                    case "quite":
                        break End;
                    case "help":
                        printHelp();
                        break;
                    case "color":
                        console.println("\u001B[33m======>\u001B[0m\"" + line + "\"");
                        break;
                    default:
                        //System.out.println("Invalid command, For assistance press TAB or type \"help\" then hit ENTER.");                        
                        console.println("Def: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to jLine Sample App. For assistance press TAB or type \"help\" then hit ENTER.");
    }

    private static void printHelp() {
        System.out.println("help            - Show help");
        System.out.println("action1         - Execute action1");
        System.out.println("action2         - Execute action2");
        System.out.println("exit            - Exit the app");

    }
}
