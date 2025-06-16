package com.minwei.notion.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * 文件对象
 *
 * @author lmw 2025/06/16
 */
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
        @JsonSubTypes.Type(name = "file", value = NotionFile.class),
        @JsonSubTypes.Type(name = "external", value = ExternalFile.class),
})
@Data
public abstract class File {

    /** 文件类型 **/
    @JsonProperty("type")
    private String type;
}
