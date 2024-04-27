package com.cooperstandard.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.PathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * @author tiago.teixeira
 */
public class SpringContext {

    private static String[] basePackages = { "config", "dbs" };
    private static AnnotationConfigApplicationContext context = loadContext(getProfile());

    public static ApplicationContext getContext() {
        return context;
    }

    private static AnnotationConfigApplicationContext loadContext(String profile) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setAllowBeanDefinitionOverriding(true);
        applicationContext.getEnvironment().setActiveProfiles(profile);
        applicationContext.scan(getBasePackages());
        applicationContext.refresh();
        return applicationContext;
    }

    private static String[] getBasePackages() {
        return Stream.of(basePackages).map("com.cooperstandard."::concat).toArray(String[]::new);
    }

    public static String getProfile() {
        try {
            return Files.readAllLines(new PathResource("config/application.yml").getFile().toPath()).stream()
                    .filter(s -> s.contains("active")).reduce("", (s, s2) -> s = s2.replaceAll("active: ", "").trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "default";
    }
}
