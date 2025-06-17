package com.minwei.notion.model.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Notion链接对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class NotionLink {

    /** URL **/
    @JsonProperty("url")
    private String url;

}
