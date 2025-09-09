package com.minwei.api.model.file;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Map;

/**
 * Notion托管的文件对象
 *
 * @author lmw 2025/09/08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NotionFile extends File {

    private NotionFileInfo file;

    @Data
    private static class NotionFileInfo {

        private String url;

        // 同时指定路径和日期格式
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
        private Date expiryTime;

    }
}
