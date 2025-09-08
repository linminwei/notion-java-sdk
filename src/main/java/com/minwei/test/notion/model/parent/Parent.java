package com.minwei.test.notion.model.parent;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * Notion父对象基类
 *
 * @author lmw 2025/06/16
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true
)
//@JsonSubTypes({
//        @JsonSubTypes.Type(name = "page_id", value = PageParent.class),
//        @JsonSubTypes.Type(name = "database_id", value = DatabaseParent.class),
//        @JsonSubTypes.Type(name = "block_id", value = BlockParent.class)
//})
@Data
public abstract class Parent {

    /** 父对象类型 **/
    @JsonProperty("type")
    private String type;
}
