package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 段落块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParagraphBlock extends NotionBlock {

    private ParagraphContent paragraph;

    public ParagraphBlock(String content) {
        this.paragraph = new ParagraphContent(Collections.singletonList(new RichText(content)), NotionColor.DEFAULT, null);
    }

    public ParagraphBlock(String content, NotionColor notionColor) {
        this.paragraph = new ParagraphContent(Collections.singletonList(new RichText(content)), notionColor, null);
    }

    public ParagraphBlock(String content, NotionColor notionColor, List<NotionBlock> blocks) {
        this.paragraph = new ParagraphContent(Collections.singletonList(new RichText(content)), notionColor, blocks);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ParagraphContent {

        private List<RichText> richText;

        private NotionColor color;

        List<NotionBlock> children;
    }

}
