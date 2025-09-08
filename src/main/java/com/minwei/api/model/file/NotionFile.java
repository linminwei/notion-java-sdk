package com.minwei.api.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.test.notion.model.property.Date;
import lombok.Data;

/**
 * Notion托管的文件对象
 *
 * @author lmw 2025/09/08
 */
@Data
public class NotionFile extends File {

    @JsonProperty("type")
    private String type;

    @JsonProperty("file.url")
    private String url;

    // 链接过期的日期和时间
    @JsonProperty("file.expiry_time")
    private Date expiryTime;

}
