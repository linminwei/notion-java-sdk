package com.minwei.model.file;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.model.common.richtext.RichText;
import com.minwei.model.icon.Icon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lmw
 * 文件对象
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NotionFile.class, name = "file"),
        @JsonSubTypes.Type(value = ExternalFile.class, name = "external")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class File extends Icon {

    /**
     * 文件标题
     */
    private List<RichText> caption;

    /**
     * 文件块名称
     */
    private String name;

}
