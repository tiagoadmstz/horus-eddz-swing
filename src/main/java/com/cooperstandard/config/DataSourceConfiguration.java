package com.cooperstandard.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataSourceConfiguration {

    private String driver;
    private String url;
    private String username;
    private String password;
}
