package com.minwei.notion.databases.query.sort;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum DirectionEnum {
    ASCENDING("ascending"),
    DESCENDING("descending");

    private final String value;

    DirectionEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static DirectionEnum fromValue(String value) {
        for (DirectionEnum directionEnum : values()) {
            if (Objects.equals(value, directionEnum.getValue())) {
                return directionEnum;
            }
        }
        return null;
    }
}

