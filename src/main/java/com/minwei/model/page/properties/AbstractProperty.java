package com.minwei.model.page.properties;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 页面属性
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TitleProperty.class, name = "title"),
        @JsonSubTypes.Type(value = RichTextProperty.class, name = "rich_text"),
})
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractProperty {

    /**
     * 属性的基础标识符
     */
    private String id;

    /**
     * 属性的类型
     */
    private String type;
}
