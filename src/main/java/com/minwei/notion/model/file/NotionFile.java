package com.minwei.notion.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Notion托管文件对象
 * 用户通过Notion应用程序手动上传的文件
 *
 * @author lmw 2025/06/18
 */
@Data
public class NotionFile implements File {

    @JsonProperty("type")
    private final String type = "file";

    @JsonProperty("file")
    private NotionFileInfo file;


    @Data
    public static class NotionFileInfo {

        /** url **/
        @JsonProperty("url")
        private String url;

        /** 链接过期时间 **/
        @JsonProperty("expiry_time")
        private Date expiryTime;
    }
}
