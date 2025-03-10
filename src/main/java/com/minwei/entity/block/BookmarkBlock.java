package com.minwei.entity.block;

import com.minwei.entity.common.RichText;
import lombok.Data;

import java.util.Collections;

/**
 * 书签块对象
 *
 * @author lmw
 */
@Data
public class BookmarkBlock extends AbstractBlock {
    /**
     * 书签内容
     */
    private Bookmark bookmark;

    public BookmarkBlock() {
        super("bookmark");
    }

    public BookmarkBlock(String caption, String url) {
        super("bookmark");
        this.bookmark = new Bookmark(Collections.singletonList(new RichText(caption)), url);
    }


}
