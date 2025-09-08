package com.minwei.test.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Notion颜色枚举
 *
 * @author lmw
 */
public enum TimeZone {
    UTC("UTC"),
    ASIA_SHANGHAI("Asia/Shanghai"),
    AMERICA_NEW_YORK("America/New_York"),
    EUROPE_LONDON("Europe/London"),
    AUSTRALIA_SYDNEY("Australia/Sydney");

    private final String value;

    TimeZone(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TimeZone fromValue(String value) {
        for (TimeZone c : TimeZone.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "NotionColor{" +
                "value='" + value + '\'' +
                '}';
    }
}
