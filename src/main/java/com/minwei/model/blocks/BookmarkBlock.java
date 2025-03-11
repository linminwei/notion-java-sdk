package com.minwei.model.blocks;

import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 书签块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkBlock extends NotionBlock {

    private BookmarkContent bookmark;

    public BookmarkBlock(String caption, String url) {
        this.bookmark = new BookmarkContent(Collections.singletonList(new RichText(caption)), url);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class BookmarkContent {

        private List<RichText> caption;

        private String url;
    }
}
