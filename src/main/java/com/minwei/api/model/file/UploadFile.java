package com.minwei.api.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Notion通过API上传的文件对象
 *
 * @author lmw 2025/09/08
 */
@Data
public class UploadFile extends File {

    @JsonProperty("file_upload.id")
    private String id;

}
