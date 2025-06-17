package com.minwei.notion.model.file;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 文件上传对象
 *
 * @author lmw 2025/06/18
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UploadFile extends File {

    @JsonProperty("file_upload")
    private UploadFileContent fileUpload;

    /**
     * 文件上传对象内容
     */
    @Data
    public static class UploadFileContent {

        /** ID **/
        @JsonProperty("id")
        private String id;

        /** 创建时间 **/
        @JsonProperty("created_time")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
        private Date createdTime;

        /** 最后修改时间 **/
        @JsonProperty("last_edited_time")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
        private Date lastEditedTime;

        /** 文件上传状态 **/
        @JsonProperty("status")
        private String status;

        /** 上传文件的MIME内容类型 **/
        @JsonProperty("content_type")
        private String contentType;

        /** 文件的总大小,以字节为单位 **/
        @JsonProperty("content_length")
        private Integer contentLength;

        /** 发送文件的内容的URL **/
        @JsonProperty("upload_url")
        private String uploadUrl;

        /** 用于完成多部分文件上传的URL **/
        @JsonProperty("completeUrl")
        private String complete_url;

        /** 提供有关使用外部URL将文件导入Notion的成功或失败的详细信息 **/
        @JsonProperty("file_import_result")
        private String fileImportResult;

    }

}
