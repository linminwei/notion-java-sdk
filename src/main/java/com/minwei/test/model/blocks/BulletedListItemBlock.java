package com.minwei.test.model.blocks;

import com.minwei.test.enums.NotionColor;
import com.minwei.test.model.common.richtext.RichText;
import com.minwei.test.model.common.richtext.text.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author lmw
 * 项目符号列表项块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletedListItemBlock extends NotionBlock {

    private BulletedListItemContent bulletedListItem;

    public BulletedListItemBlock(String content) {
        this.bulletedListItem = new BulletedListItemContent(content, NotionColor.DEFAULT, null);
    }

    public BulletedListItemBlock(String content, NotionColor notionColor) {
        this.bulletedListItem = new BulletedListItemContent(content, notionColor, null);
    }

    public BulletedListItemBlock(String content, NotionColor notionColor, List<NotionBlock> children) {
        this.bulletedListItem = new BulletedListItemContent(content, notionColor, children);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class BulletedListItemContent {

        /**
         * 块中的富文本
         */
        private List<RichText> richText;

        /**
         * 块的颜色
         */
        private NotionColor color;

        /**
         * 块的嵌套子块
         */
        private List<NotionBlock> children;


        public BulletedListItemContent(String content, NotionColor color, List<NotionBlock> children) {
            this.richText = Collections.singletonList(new Text(content));
            this.color = color;
            this.children = children;
        }
    }

}
