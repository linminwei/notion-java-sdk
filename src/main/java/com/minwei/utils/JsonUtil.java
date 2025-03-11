package com.minwei.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;

/**
 * JSON工具类
 *
 * @author lmw
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        // 全部设置蛇形映射
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        // 反序列化忽略不存在的值
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 序列化忽略null值
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 没有需序列化的成员
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to object", e);
        }
    }

    public static <T> T fromJson(String json, JavaType javaType) {
        try {
            return objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to object", e);
        }
    }

    public static <T> T fromJsonByParametricType(String json, Class<T> parametrized, Class<?> parameterClasses) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);

        return fromJson(json, javaType);
    }
}
