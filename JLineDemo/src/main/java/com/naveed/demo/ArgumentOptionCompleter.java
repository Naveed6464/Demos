/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import jline.console.completer.ArgumentCompleter;
import jline.console.completer.ArgumentCompleter.WhitespaceArgumentDelimiter;
import jline.console.completer.Completer;
import static jline.internal.Preconditions.checkNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author naveed
 */
public class ArgumentOptionCompleter implements Completer {

    private static final Logger log = LoggerFactory.getLogger(ArgumentOptionCompleter.class);
    private final ArgumentCompleter.ArgumentDelimiter delimiter;

    private final SortedSet<String> allStrings = new TreeSet<>();
    private final String argument;
    private final SortedSet<String> allOptions = new TreeSet<>();    

    public ArgumentOptionCompleter(List<String> options, String argument) {
        checkNotNull(argument);
        this.argument = argument;
        allStrings.addAll(Arrays.asList(argument));
        allStrings.addAll(options);
        allOptions.addAll(options);
        this.delimiter = checkNotNull(new WhitespaceArgumentDelimiter());
    }

    /**
     *
     * @param buffer
     * @param cursor
     * @param candidates
     * @return
     */
    @Override
    public int complete(final String buffer, final int cursor, final List<CharSequence> candidates) {
        // buffer can be null
        checkNotNull(candidates);

        ArgumentCompleter.ArgumentList argumentList = delimiter.delimit(buffer, cursor);

        int argpos = argumentList.getArgumentPosition();
        int argIndex = argumentList.getCursorArgumentIndex();

        if (argIndex < 0) {
            return -1;
        }
        if (!argument.startsWith(argumentList.getArguments()[0])) {
            return -1;
        }
        int ret = complete(argumentList.getArguments()[0], argumentList.getCursorArgument(), argpos, candidates);

        if (ret == -1) {
            return -1;
        }

        int pos = ret + argumentList.getBufferPosition() - argpos;

        // Special case: when completing in the middle of a line, and the area under the cursor is a delimiter,
        // then trim any delimiters from the candidates, since we do not need to have an extra delimiter.
        //
        // E.g., if we have a completion for "foo", and we enter "f bar" into the buffer, and move to after the "f"
        // and hit TAB, we want "foo bar" instead of "foo  bar".
        if ((cursor != buffer.length()) && delimiter.isDelimiter(buffer, cursor)) {
            for (int i = 0; i < candidates.size(); i++) {
                CharSequence val = candidates.get(i);

                while (val.length() > 0 && delimiter.isDelimiter(val, val.length() - 1)) {
                    val = val.subSequence(0, val.length() - 1);
                }

                candidates.set(i, val);
            }
        }
        //Log.trace("Completing ", buffer, " (pos=", cursor, ") with: ", candidates, ": offset=", pos);
        return pos;
    }

    public int complete(String firstIndex, String buffer, int cursor, List<CharSequence> candidates) {
        if (buffer == null) {
            candidates.addAll(allOptions);
        } else {
            for (String match : allStrings.tailSet(buffer)) {
                if (!match.startsWith(buffer)) {
                    break;
                }
                candidates.add(match);
            }
        }
        if (candidates.isEmpty()) {
            candidates.add(buffer);
        }
        if (candidates.size() == 1) {
            candidates.set(0, candidates.get(0) + " ");
        }
        return candidates.isEmpty() ? -1 : 0;
    }

}
