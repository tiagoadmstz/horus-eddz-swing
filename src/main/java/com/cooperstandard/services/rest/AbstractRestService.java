package com.cooperstandard.services.rest;

import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

abstract class AbstractRestService {

    protected static final String BASE_URL = "http://localhost:8080/horus";

    protected final Logger logger;
    protected final RestTemplate restTemplate;

    AbstractRestService() {
        this.logger = Logger.getLogger("RestService");
        this.restTemplate = new RestTemplate();
    }
}
