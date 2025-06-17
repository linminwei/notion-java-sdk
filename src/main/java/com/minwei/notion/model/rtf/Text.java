package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.notion.model.common.NotionLink;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文本对象
 *
 * @author lmw 2025/06/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Text extends RichText{

    private TextContent text;

    @Data
    public static class TextContent {

        /** 文本的实际文本内容 **/
        @JsonProperty("content")
        private String content;

        /** 链接对象 **/
        @JsonProperty("link")
        private NotionLink link;
    }

}
