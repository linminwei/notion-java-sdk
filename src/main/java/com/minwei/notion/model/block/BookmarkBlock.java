package com.minwei.notion.model.block;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.notion.model.rtf.RichText;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 书签块对象
 *
 * @author lmw 2025/06/18
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BookmarkBlock extends Block {

    @JsonProperty("bookmark")
    private BookmarkBlockContent bookmark;

    @Data
    public static class BookmarkBlockContent {

        /** 书签的标题 **/
        @JsonProperty("caption")
        List<RichText> caption;

        /** 书签的链接 **/
        @JsonProperty("url")
        private String url;

    }

}
