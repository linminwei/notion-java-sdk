package com.minwei.test.model.common.parent;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 父对象抽象
 *
 * @author lmw
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DatabaseParent.class, name = "database_id"),
        @JsonSubTypes.Type(value = PageParent.class, name = "page_id"),
        @JsonSubTypes.Type(value = BlockParent.class, name = "block_id")
})
@Data
@AllArgsConstructor
public abstract class Parent {
}
