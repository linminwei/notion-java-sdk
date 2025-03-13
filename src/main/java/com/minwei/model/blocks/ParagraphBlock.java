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
 * 段落块
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParagraphBlock extends NotionBlock {

    private ParagraphContent paragraph;

    public ParagraphBlock(String content) {
        this.paragraph = new ParagraphContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, null);
    }

    public ParagraphBlock(String content, NotionColor color) {
        this.paragraph = new ParagraphContent(Collections.singletonList(new Text(content)), color, null);
    }

    public ParagraphBlock(String content, List<NotionBlock> blocks) {
        this.paragraph = new ParagraphContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, blocks);
    }

    public ParagraphBlock(String content, NotionColor color, List<NotionBlock> blocks) {
        this.paragraph = new ParagraphContent(Collections.singletonList(new Text(content)), color, blocks);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ParagraphContent {

        List<RichText> richText;

        NotionColor color;

        List<NotionBlock> children;
    }
}
