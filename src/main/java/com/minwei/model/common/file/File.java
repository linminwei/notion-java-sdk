package com.minwei.model.common.file;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通用文件对象
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
        @JsonSubTypes.Type(value = NotionFile.class, name = "file"),
        @JsonSubTypes.Type(value = ExternalFile.class, name = "external")
})
@AllArgsConstructor
public abstract class File {
}
