package com.minwei.notion.model.file;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
* Notion托管文件对象
*
* @author lmw 2025/06/18
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class NotionFile extends File {

    @JsonProperty("file")
    private NotionFileContent file;

    /**
     * Notion托管文件对象内容
     */
    @Data
    public static class NotionFileContent {
        @JsonProperty("url")
        private String url;

        @JsonProperty("expiry_time")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
        private Date expiryTime;
    }


}
