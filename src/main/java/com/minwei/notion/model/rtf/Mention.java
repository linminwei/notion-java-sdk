package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
* 提及对象
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
        @JsonSubTypes.Type(name = "database", value = MentionDatabase.class),
        @JsonSubTypes.Type(name = "date", value = MentionDate.class),
        @JsonSubTypes.Type(name = "link_preview", value = MentionLinkPreview.class),
        @JsonSubTypes.Type(name = "page", value = MentionPage.class),
})
public abstract class Mention {

    /** 提及对象类型 **/
    @JsonProperty("type")
    private String type;

}
