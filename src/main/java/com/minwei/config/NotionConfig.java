package com.minwei.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author lmw
 */
@Configuration
@ConfigurationProperties("notion.entity")
@Data
public class NotionConfig {

    private Map<String,String> databaseId;

    private Map<String,String> token;


    public String databaseId(String classFullName){
        // 获取databaseId
        return databaseId.get(classFullName);
    }

    public String token(String classFullName){
        // 获取databaseId
        return token.get(classFullName);
    }
}
