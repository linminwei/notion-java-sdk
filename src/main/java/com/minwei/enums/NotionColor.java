package com.minwei.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Notion颜色枚举
 *
 * @author lmw
 */
public enum NotionColor {
    DEFAULT("default"),
    BLUE("blue"),
    BLUE_BACKGROUND("blue_background"),
    BROWN("brown"),
    BROWN_BACKGROUND("brown_background"),
    GRAY("gray"),
    GRAY_BACKGROUND("gray_background"),
    GREEN("green"),
    GREEN_BACKGROUND("green_background"),
    ORANGE("orange"),
    ORANGE_BACKGROUND("orange_background"),
    YELLOW("yellow"),
    YELLOW_BACKGROUND("yellow_background"),
    PINK("pink"),
    PINK_BACKGROUND("pink_background"),
    PURPLE("purple"),
    PURPLE_BACKGROUND("purple_background"),
    RED("red"),
    RED_BACKGROUND("red_background");

    private final String value;

    NotionColor(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static NotionColor fromValue(String value) {
        for (NotionColor c : NotionColor.values()) {
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
