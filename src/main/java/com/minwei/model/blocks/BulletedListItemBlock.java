package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 项目符号列表项块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletedListItemBlock extends NotionBlock {

    private BulletedListItemContent bulletedListItem;

    public BulletedListItemBlock(String contents) {
        this.bulletedListItem = new BulletedListItemContent(contents);
    }

    public BulletedListItemBlock(String contents, List<NotionBlock> blocks) {
        this.bulletedListItem = new BulletedListItemContent(contents, blocks);
    }

    public BulletedListItemBlock(String contents, NotionColor color) {
        this.bulletedListItem = new BulletedListItemContent(contents, color);
    }

    public BulletedListItemBlock(String contents, NotionColor color, List<NotionBlock> blocks) {
        this.bulletedListItem = new BulletedListItemContent(contents, color, blocks);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class BulletedListItemContent {
        private List<RichText> richText;

        private NotionColor color = NotionColor.DEFAULT;

        private List<NotionBlock> children;

        public BulletedListItemContent(String content) {
            this.richText = Collections.singletonList(new RichText(content));
        }


        public BulletedListItemContent(String content, NotionColor color) {
            this.richText = Collections.singletonList(new RichText(content));
            this.color = color;
        }

        public BulletedListItemContent(String content, List<NotionBlock> blocks) {
            this.richText = Collections.singletonList(new RichText(content));
            this.children = blocks;
        }

        public BulletedListItemContent(String content, NotionColor color, List<NotionBlock> blocks) {
            this.richText = Collections.singletonList(new RichText(content));
            this.color = color;
            this.children = blocks;
        }
    }


}
