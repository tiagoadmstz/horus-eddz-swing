package com.cooperstandard.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author tiago.teixeira
 */
@Data
@Configuration
public class EddzConfiguration {

    private final Map<String, DataSourceConfiguration> datasource;

    public EddzConfiguration(Map<String, DataSourceConfiguration> datasource) {
        this.datasource = datasource;
    }
}
