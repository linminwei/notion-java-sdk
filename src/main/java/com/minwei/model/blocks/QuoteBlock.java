package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.richtext.RichText;
import com.minwei.model.common.richtext.text.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author lmw
 * 引用块
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteBlock extends NotionBlock {

    private QuoteContent quote;

    public QuoteBlock(String content) {
        this.quote = new QuoteContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, null);
    }

    public QuoteBlock(String content, NotionColor color) {
        this.quote = new QuoteContent(Collections.singletonList(new Text(content)), color, null);
    }

    public QuoteBlock(String content, List<NotionBlock> blocks) {
        this.quote = new QuoteContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, blocks);
    }

    public QuoteBlock(String content, NotionColor color, List<NotionBlock> blocks) {
        this.quote = new QuoteContent(Collections.singletonList(new Text(content)), color, blocks);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class QuoteContent {

        List<RichText> richText;

        NotionColor color;

        List<NotionBlock> children;

    }


}
