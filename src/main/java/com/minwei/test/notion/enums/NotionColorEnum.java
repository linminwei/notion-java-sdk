package com.minwei.test.notion.enums;


import lombok.Getter;

/**
 * Notion颜色枚举
 *
 * @author lmw 2025/06/18
 */
@Getter
public enum NotionColorEnum {

    BLUE("blue","蓝色"),
    BLUE_BACKGROUND("blue_background","蓝色背景色"),
    BROWN("brown","棕色"),
    BROWN_BACKGROUND("brown_background","棕色背景色"),
    DEFAULT("default","默认颜色"),
    GRAY("gray","灰色"),
    GRAY_BACKGROUND("gray_background","灰色背景色"),
    GREEN("green","绿色"),
    GREEN_BACKGROUND("green_background","绿色背景色"),
    ORANGE("orange","橘色"),
    ORANGE_BACKGROUND("orange_background","橘色背景色"),
    PINK("pink","粉色"),
    PINK_BACKGROUND("pink_background","粉色背景色"),
    PURPLE("purple","紫色"),
    PURPLE_BACKGROUND("purple_background","紫色背景色"),
    RED("red_background","红色"),
    RED_BACKGROUND("red_background","红色背景色"),
    YELLOW("yellow","黄色"),
    YELLOW_BACKGROUND("yellow_background","黄色背景色");

    /** 颜色编码 **/
    private final String colorCode;

    /** 颜色名称 **/
    private final String colorName;


    NotionColorEnum(String colorCode, String colorName) {
        this.colorCode = colorCode;
        this.colorName = colorName;
    }
}
