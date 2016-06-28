/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.util.List;
import jline.console.completer.Completer;

/**
 *
 * @author naveed
 */
public interface IShell {

    /**
     * The slot name to use with {@link #flash(Level, String, String)} if a
     * caller wishes to modify the window title. This may not be supported by
     * all operating system shells. It is provided on a best-effort basis only.
     */
    String WINDOW_TITLE_SLOT = "WINDOW_TITLE_SLOT";

    /**
     * Presents a console prompt and allows the user to interact with the shell.
     * The shell should not return to the caller until the user has finished
     * their session (by way of a "quit" or similar command).
     */
    void promptLoop();

    /**
     * Runs the specified command. Control will return to the caller after the
     * command is run.
     *
     * @param line to execute (required)
     * @return true if the command was successful, false if there was an
     * exception
     */
    CommandResult executeCommand(String line);

    /**
     * Changes the "path" displayed in the shell prompt. An implementation will
     * ensure this path is included on the screen, taking care to merge it with
     * the product name and handle any special formatting requirements (such as
     * ANSI, if supported by the implementation).
     *
     * @param prompt to set (can be null or empty; must NOT be formatted in any
     * special way eg ANSI codes)
     */
    void setPrompt(String prompt);

    /**
     *
     * @param text
     */
    void setBannerText(String text);

    void setHelpMessage(String msg);

    void addCompleter(Completer completer);

    void addCompleters(List<Completer> completers);

    void addCommands(String[] commands);
}
