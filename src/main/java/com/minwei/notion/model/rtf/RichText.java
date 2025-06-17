package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
* 富文本基对象
*
* @author lmw 2025/06/18
*/
@Data
@JsonTypeInfo(
        /* 表示使用类型名称作为类型表示 **/
        use = JsonTypeInfo.Id.NAME,
        /* 指定用于存储类型信息的JSON属性名 */
        property = "type",
        /* 表示类型信息将被包含在已存在的属性中 */
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        /* 表示类型信息将被包含在已存在的属性中 */
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "equation", value = Equation.class),
        @JsonSubTypes.Type(name = "mention", value = Mention.class),
        @JsonSubTypes.Type(name = "text", value = Text.class),
})
public abstract class RichText {

    /** 富文本基对象类型 **/
    @JsonProperty("type")
    private String type;

    /** 富文本对象样式 **/
    @JsonProperty("annotations")
    private Annotation annotations;

    /** 没有注释的纯文本 **/
    @JsonProperty("plain_text")
    private String plainText;

    /** 本文中提及的任何链接或Notion的URL **/
    @JsonProperty("href")
    private String href;


    @Data
    public static class Annotation {

        /** 文本是否为粗体 **/
        @JsonProperty("bold")
        private Boolean bold;

        /** 文本是否为斜体 **/
        @JsonProperty("italic")
        private Boolean italic;

        /** 文本是否被删除 **/
        @JsonProperty("strikethrough")
        private Boolean strikethrough;

        /** 文本是否带有下划线 **/
        @JsonProperty("underline")
        private Boolean underline;

        /** 文本是否为代码块 **/
        @JsonProperty("code")
        private Boolean code;

        /** 文本颜色 **/
        @JsonProperty("color")
        private String color;
    }
}
