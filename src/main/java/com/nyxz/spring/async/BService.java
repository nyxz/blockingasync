package com.nyxz.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class BService {

    private static final Logger LOG = LoggerFactory.getLogger(BService.class);

    @Async
    public CompletableFuture<String> b(int num) {
        LOG.info("Executing b(num)");
        ProcessingSimulator.process();
        return CompletableFuture.completedFuture("The mighty result " + num);
    }
}
