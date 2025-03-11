package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 引用块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteBlock extends NotionBlock {

    private QuoteContent paragraph;

    public QuoteBlock(String content) {
        this.paragraph = new QuoteContent(Collections.singletonList(new RichText(content)), NotionColor.DEFAULT, null);
    }

    public QuoteBlock(String content, NotionColor notionColor) {
        this.paragraph = new QuoteContent(Collections.singletonList(new RichText(content)), notionColor, null);
    }

    public QuoteBlock(String content, NotionColor notionColor, List<NotionBlock> blocks) {
        this.paragraph = new QuoteContent(Collections.singletonList(new RichText(content)), notionColor, blocks);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class QuoteContent {

        private List<RichText> richText;

        private NotionColor color;

        List<NotionBlock> children;
    }

}
