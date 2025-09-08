package com.minwei.test.notion.model.file;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 文件基对象
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
        @JsonSubTypes.Type(name = "file", value = NotionFile.class),
        @JsonSubTypes.Type(name = "file_upload", value = UploadFile.class),
        @JsonSubTypes.Type(name = "external", value = ExternalFile.class),
})
public interface File{

    String getType();

}
