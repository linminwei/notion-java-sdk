package com.minwei.api.model.file;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;


/**
 * Notion文件基础对象
 *
 * @author lmw 2025/09/08
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "file", value = NotionFile.class),
        @JsonSubTypes.Type(name = "file_upload", value = UploadFile.class),
        @JsonSubTypes.Type(name = "external", value = ExternalFile.class)
})
@Data
public abstract class File {

    private String type;

}
