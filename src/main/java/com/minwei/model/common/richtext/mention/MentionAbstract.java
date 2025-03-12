package com.minwei.model.common.richtext.mention;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 富文本提及对象抽象
 * 提及对象表示数据库、日期、链接预览提及、页面、模板提及或用户的内联提及
 *
 * @author lmw
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MentionDatabase.class, name = "database"),
        @JsonSubTypes.Type(value = MentionDate.class, name = "date"),
        @JsonSubTypes.Type(value = MentionLinkPreview.class, name = "link_preview"),
        @JsonSubTypes.Type(value = MentionPage.class, name = "page"),
})
@Data
@AllArgsConstructor
public abstract class MentionAbstract {

}
