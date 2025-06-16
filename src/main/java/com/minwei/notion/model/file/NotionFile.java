package com.minwei.notion.model.file;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Notion托管文件对象
 *
 * @author lmw 2025/06/16
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class NotionFile extends File {

    /** 文件在Notion中的URL链接 **/
    @JsonProperty("url")
    private String url;

    /** 链接的过期时间 **/
    @JsonProperty("expiry_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date expiryTime;

}
