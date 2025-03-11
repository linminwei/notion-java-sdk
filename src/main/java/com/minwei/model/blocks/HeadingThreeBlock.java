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
 * h3标题块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadingThreeBlock extends NotionBlock {

    @JsonProperty("heading_3")
    private HeadingThreeContent HeadingThreeContent;

    public HeadingThreeBlock(String title) {
        this.HeadingThreeContent = new HeadingThreeContent(title);
    }

    public HeadingThreeBlock(String title, NotionColor color) {
        this.HeadingThreeContent = new HeadingThreeContent(title, color);
    }

    public HeadingThreeBlock(String title, NotionColor color, boolean isToggleable) {
        this.HeadingThreeContent = new HeadingThreeContent(title, color, isToggleable);
    }

    public HeadingThreeBlock(String title, boolean isToggleable) {
        this.HeadingThreeContent = new HeadingThreeContent(title, isToggleable);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class HeadingThreeContent {

        private List<RichText> richText;

        private NotionColor color = NotionColor.DEFAULT;

        /**
         * 标题块是否为切换标题。若是,则标题块将切换并可以支持子项。否则则标题块是静态标题块
         */
        @JsonProperty("is_toggleable")
        private boolean isToggleable;


        public HeadingThreeContent(String title) {
            this(Collections.singletonList(new RichText(title)), NotionColor.DEFAULT, false);
        }

        public HeadingThreeContent(String title, NotionColor color) {
            this(Collections.singletonList(new RichText(title)), color, false);
        }

        public HeadingThreeContent(String title, boolean isToggleable) {
            this(Collections.singletonList(new RichText(title)), NotionColor.DEFAULT, isToggleable);
        }

        public HeadingThreeContent(String title, NotionColor color, boolean isToggleable) {
            this(Collections.singletonList(new RichText(title)), color, isToggleable);
        }
    }

}
