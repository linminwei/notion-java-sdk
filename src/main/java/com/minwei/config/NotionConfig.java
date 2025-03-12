package com.minwei.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author lmw
 */
@Configuration
@ConfigurationProperties(prefix = "notion")
@Data
public class NotionConfig {

    private String token;

    private Map<String, String> database;

    public String databaseId(String classFullName) {
        return database.get(classFullName);
    }
}
