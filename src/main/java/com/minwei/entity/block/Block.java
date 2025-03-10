package com.minwei.entity.block;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Block接口,表示Notion中的块类型
 * 使用 Jackson 的多态支持，通过 type 字段区分不同块类型
 *
 * @author lmw
 */
@JsonTypeInfo(
        // 使用块类型名称作为标识
        use = JsonTypeInfo.Id.NAME,
        // 将类型信息作为 JSON 的一个属性
        include = JsonTypeInfo.As.PROPERTY,
        // 类型信息对应的 JSON 属性名
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BookmarkBlock.class, name = "bookmark")
})
public interface Block {

    String getType();

    String getObject();
}
