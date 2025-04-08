package com.minwei.notion.databases.query.sort;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum TimestampEnum {
    CREATED_TIME("created_time"),
    LAST_EDITED_TIME("last_edited_time");

    private final String value;

    TimestampEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TimestampEnum fromValue(String value) {
        for (TimestampEnum directionEnum : values()) {
            if (Objects.equals(value, directionEnum.getValue())) {
                return directionEnum;
            }
        }
        return null;
    }
}
