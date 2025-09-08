package com.minwei.test.notion.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.test.notion.model.common.Cover;
import com.minwei.test.notion.model.common.Icon;
import lombok.Data;

/**
 * API上传文件对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class UploadFile implements File, Icon, Cover{

    @JsonProperty("type")
    private final String type = "file_upload";

    @JsonProperty("name")
    private String name;

    @JsonProperty("file_upload")
    private UploadFileInfo uploadFile;


    @Data
    public static class UploadFileInfo {

        /** 文件上传对象的ID **/
        @JsonProperty("id")
        private String id;

    }
}
