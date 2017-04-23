package com.nyxz.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AService {

    private static final Logger LOG = LoggerFactory.getLogger(AService.class);

    @Autowired
    private BService bService;

    @Async
    public CompletableFuture<String> a() {
        LOG.info("Executing a()");
        final int num = num();
        return bService.b(num)
                .thenApply(String::toUpperCase);
    }

    private int num() {
        LOG.info("Calculate number...");
        ProcessingSimulator.process();
        return 10;
    }
}
