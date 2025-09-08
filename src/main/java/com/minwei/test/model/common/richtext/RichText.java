package com.minwei.test.model.common.richtext;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.test.model.common.richtext.equation.Equation;
import com.minwei.test.model.common.richtext.mention.Mention;
import com.minwei.test.model.common.richtext.text.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 富文本对象
 *
 * @author lmw
 */

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Text.class, name = "text"),
        @JsonSubTypes.Type(value = Equation.class, name = "equation"),
        @JsonSubTypes.Type(value = Mention.class, name = "mention")
})
@AllArgsConstructor
@NoArgsConstructor
public abstract class RichText {

    /**
     * 富文本对象类型
     * text、mention、equation
     */
    private String type;

    /**
     * 富文本样式对象
     */
    private Annotation annotations;

    /**
     * 没有注释的纯文本
     */
    private String plainText;

    /**
     * 提及的任何链接或Notion的URL
     */
    private String href;

}
