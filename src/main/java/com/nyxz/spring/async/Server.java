package com.nyxz.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Server {

    private static final Logger LOG = LoggerFactory.getLogger(Server.class);

    @Autowired
    private AService aService;

    public CompletableFuture<String> makeRequest() {
        LOG.info("Making request.");
        final CompletableFuture<String> result = aService.a();
        LOG.info("Returning response.");
        return result;
    }
}
