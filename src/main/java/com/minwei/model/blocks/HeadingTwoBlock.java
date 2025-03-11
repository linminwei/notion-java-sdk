package com.minwei.model.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * h2标题块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadingTwoBlock extends NotionBlock {

    @JsonProperty("heading_2")
    private HeadingTwoContent HeadingTwoContent;

    public HeadingTwoBlock(String title) {
        this.HeadingTwoContent = new HeadingTwoContent(title);
    }

    public HeadingTwoBlock(String title, NotionColor color) {
        this.HeadingTwoContent = new HeadingTwoContent(title, color);
    }

    public HeadingTwoBlock(String title, NotionColor color, boolean isToggleable) {
        this.HeadingTwoContent = new HeadingTwoContent(title, color, isToggleable);
    }

    public HeadingTwoBlock(String title, boolean isToggleable) {
        this.HeadingTwoContent = new HeadingTwoContent(title, isToggleable);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class HeadingTwoContent {

        private List<RichText> richText;

        private NotionColor color = NotionColor.DEFAULT;

        /**
         * 标题块是否为切换标题。若是,则标题块将切换并可以支持子项。否则则标题块是静态标题块
         */
        @JsonProperty("is_toggleable")
        private boolean isToggleable;


        public HeadingTwoContent(String title) {
            this(Collections.singletonList(new RichText(title)), NotionColor.DEFAULT, false);
        }

        public HeadingTwoContent(String title, NotionColor color) {
            this(Collections.singletonList(new RichText(title)), color, false);
        }

        public HeadingTwoContent(String title, boolean isToggleable) {
            this(Collections.singletonList(new RichText(title)), NotionColor.DEFAULT, isToggleable);
        }

        public HeadingTwoContent(String title, NotionColor color, boolean isToggleable) {
            this(Collections.singletonList(new RichText(title)), color, isToggleable);
        }
    }

}
