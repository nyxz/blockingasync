package com.nyxz.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessingSimulator {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessingSimulator.class);

    public static void process() {
        try {
            LOG.info("Processing...");
            Thread.sleep(1000);
            LOG.info("Processing done.");
        } catch (InterruptedException e) {
            LOG.error("Thread interrupted.", e);
        }
    }
}
