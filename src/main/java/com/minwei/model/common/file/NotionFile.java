package com.minwei.model.common.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Notion托管文件对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotionFile {

    private String url;

    /**
     * 链接过期的日期和时间，格式为 ISO 8601 日期时间字符串
     * "2020-03-17T19:10:04.968Z"
     */
    private String expiryTime;
}
