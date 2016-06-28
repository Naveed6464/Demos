package com.naveed.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    /**
     * @param args the command line arguments
     */
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Started");

        logger.error("Got an Error");

        logger.debug("Debug");

        logger.warn("Closing");

    }
}
