package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 编号列表项块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberListItemBlock extends NotionBlock {

    private NumberListItemContent numberedListItem;

    public NumberListItemBlock(String contents) {
        this.numberedListItem = new NumberListItemContent(contents);
    }

    public NumberListItemBlock(String contents, List<NotionBlock> blocks) {
        this.numberedListItem = new NumberListItemContent(contents, blocks);
    }

    public NumberListItemBlock(String contents, NotionColor color) {
        this.numberedListItem = new NumberListItemContent(contents, color);
    }

    public NumberListItemBlock(String contents, NotionColor color, List<NotionBlock> blocks) {
        this.numberedListItem = new NumberListItemContent(contents, color, blocks);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class NumberListItemContent {
        private List<RichText> richText;

        private NotionColor color = NotionColor.DEFAULT;

        private List<NotionBlock> children;

        public NumberListItemContent(String content) {
            this.richText = Collections.singletonList(new RichText(content));
        }


        public NumberListItemContent(String content, NotionColor color) {
            this.richText = Collections.singletonList(new RichText(content));
            this.color = color;
        }

        public NumberListItemContent(String content, List<NotionBlock> blocks) {
            this.richText = Collections.singletonList(new RichText(content));
            this.children = blocks;
        }

        public NumberListItemContent(String content, NotionColor color, List<NotionBlock> blocks) {
            this.richText = Collections.singletonList(new RichText(content));
            this.color = color;
            this.children = blocks;
        }
    }


}
