package com.minwei.notion.model.common;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.notion.model.file.ExternalFile;
import com.minwei.notion.model.file.UploadFile;

/**
 * Notion 封面接口
 *
 * @author lmw 2025/06/18
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "external", value = ExternalFile.class),
        @JsonSubTypes.Type(name = "file_upload", value = UploadFile.class),
})
public interface Cover {
    String getType();
}
