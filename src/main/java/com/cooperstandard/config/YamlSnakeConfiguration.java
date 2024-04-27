package com.cooperstandard.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.format.support.DefaultFormattingConversionService;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

@Configuration
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class YamlSnakeConfiguration {

    @Bean
    public static YamlPropertiesFactoryBean yamlProperties() {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"), new PathResource("config/application.yml"));
        return yaml;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(final YamlPropertiesFactoryBean yamlPropertiesFactoryBean) {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        propertySourcesPlaceholderConfigurer.setNullValue("");
        propertySourcesPlaceholderConfigurer.setProperties(yamlPropertiesFactoryBean.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public static ConversionService conversionService() {
        DefaultFormattingConversionService cs = new DefaultFormattingConversionService();
        cs.addConverter(String.class, Pattern.class, Pattern::compile);
        cs.addConverter(String.class, Boolean.class, Boolean::parseBoolean);
        cs.addConverter(String.class, Image.class, YamlSnakeConfiguration::imageConversion);
        cs.addConverter(String.class, ImageIcon.class, YamlSnakeConfiguration::imageIconConversion);
        cs.addConverter(String.class, URL.class, YamlSnakeConfiguration::urlConversion);
        cs.addConverter(String.class, String[].class, YamlSnakeConfiguration::arrayStringConversion);
        cs.addConverter(String.class, Map.class, YamlSnakeConfiguration::mapConversion);
        return cs;
    }

    @Bean
    public Map<String, DataSourceConfiguration> dataSourceConfigurationMap(@Qualifier("yamlProperties") Properties properties) {
        final Map<String, DataSourceConfiguration> datasources = new HashMap<>();
        properties.entrySet().stream()
                .filter(entry -> entry.getKey().toString().startsWith("eddz.datasource"))
                .forEach(entry -> {
                    String key = extractKey(entry.getKey().toString());
                    DataSourceConfiguration dataSourceConfiguration = datasources.computeIfAbsent(key, k -> new DataSourceConfiguration());
                    setDataSourceProperty(dataSourceConfiguration, entry.getKey().toString(), entry.getValue().toString());
                });
        return datasources;
    }

    private String extractKey(String fullKey) {
        return fullKey.substring("eddz.datasource.".length(), fullKey.indexOf('.', "eddz.datasource.".length()));
    }

    private void setDataSourceProperty(DataSourceConfiguration dataSourceConfiguration, String fullKey, String value) {
        String suffixKey = fullKey.substring(fullKey.lastIndexOf('.') + 1);
        switch (suffixKey) {
            case "driver":
                dataSourceConfiguration.setDriver(value);
                break;
            case "url":
                dataSourceConfiguration.setUrl(value);
                break;
            case "username":
                dataSourceConfiguration.setUsername(value);
                break;
            case "password":
                dataSourceConfiguration.setPassword(value);
                break;
            default:
                break;
        }
    }

    private static Map mapConversion(String mapString) {
        try {
            if (mapString != null) {
                String[] split = mapString.trim().split(":");
                Long value = Long.parseLong(split[1]);
                Map<Long, Long> map = new HashMap();
                for (String s1 : split[0].replaceAll("[\\[|\\]]", "").split(",")) {
                    map.put(Long.parseLong(s1), value);
                }
                return map;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static String[] arrayStringConversion(String arrayString) {
        try {
            return Arrays.stream(arrayString.split(",")).map(String::trim).toArray(String[]::new);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static URL urlConversion(String urlString) {
        try {
            return new ClassPathResource(urlString).getURL();
        } catch (Exception ex) {
        }
        return null;
    }

    private static ImageIcon imageIconConversion(final String imageString) {
        try {
            return new ImageIcon(new PathResource(imageString).getURL());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static Image imageConversion(final String imageString) {
        try {
            return new ImageIcon(new PathResource(imageString).getURL()).getImage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
