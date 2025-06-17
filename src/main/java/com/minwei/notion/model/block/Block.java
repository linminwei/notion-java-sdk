package com.minwei.notion.model.block;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.notion.model.parent.Parent;
import lombok.Data;

import java.util.Date;

/**
* Notion块对象基类
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
        @JsonSubTypes.Type(name = "audio", value = AudioBlock.class),
        @JsonSubTypes.Type(name = "bookmark", value = BookmarkBlock.class),
        @JsonSubTypes.Type(name = "breadcrumb", value = Breadcrumb.class),
        @JsonSubTypes.Type(name = "bulleted_list_item", value = BulletedListItemBlock.class),
})
@Data
public abstract class Block {

    @JsonProperty("object")
    private String object;

    /** 块标识 **/
    @JsonProperty("id")
    private String id;

    /** 父对象 **/
    @JsonProperty("parent")
    private Parent parent;

    /** 块类型 **/
    @JsonProperty("type")
    private String type;

    /** 创建块的时间 **/
    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date createdTime;

    /** 最后更新块的时间 **/
    @JsonProperty("last_edited_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date lastEditedTime;

    /** 块的存档状态 **/
    @JsonProperty("archived")
    private Boolean archived;

    /** 块是否已删除 **/
    @JsonProperty("in_trash")
    private Boolean inTrash;

    /** 块中是否嵌套了子块 **/
    @JsonProperty("has_children")
    private Boolean hasChildren;

}
