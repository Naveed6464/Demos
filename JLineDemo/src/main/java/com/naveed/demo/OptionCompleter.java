/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import jline.console.completer.Completer;
import static jline.internal.Preconditions.checkNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author naveed
 */
public class OptionCompleter implements Completer {

    private static final Logger log = LoggerFactory.getLogger(OptionCompleter.class);
    private final SortedSet<String> allStrings = new TreeSet<>();
    private final SortedSet<String> allOptions = new TreeSet<>();

    public OptionCompleter() {
    }

    public OptionCompleter(final Collection<String> strings) {
        checkNotNull(strings);
        allStrings.addAll(strings);
    }

    public OptionCompleter(List<String> options, Collection<String> strings) {
        checkNotNull(strings);
        allStrings.addAll(strings);
        allStrings.addAll(options);
        allOptions.addAll(options);
    }

    public OptionCompleter(final String... strings) {
        this(Arrays.asList(strings));
    }

    public OptionCompleter(List<String> options, final String... strings) {
        this(options, Arrays.asList(strings));
    }

    @Override
    public int complete(String buffer, int cursor, List<CharSequence> candidates) {
        // buffer could be null
        checkNotNull(candidates);
        if (buffer == null) {
            candidates.addAll(allOptions);
        } else {
            final String pharase = buffer.trim().toLowerCase();
            for (String match : allStrings.tailSet(buffer)) {
                if (!match.startsWith(buffer)) {
                    break;
                }
                candidates.add(match);
            }
            log.info("Candidate " + candidates.size() + " " + pharase);
            if (candidates.isEmpty()) {
                candidates.add(buffer);
            }
        }

        if (candidates.size() == 1) {
            candidates.set(0, candidates.get(0) + " ");
        }

        return candidates.isEmpty() ? -1 : 0;
    }

}
