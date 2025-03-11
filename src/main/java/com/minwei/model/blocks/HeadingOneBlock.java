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
 * h1标题块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadingOneBlock extends NotionBlock {

    @JsonProperty("heading_1")
    private HeadingOneContent HeadingOneContent;

    public HeadingOneBlock(String title) {
        this.HeadingOneContent = new HeadingOneContent(title);
    }

    public HeadingOneBlock(String title, NotionColor color) {
        this.HeadingOneContent = new HeadingOneContent(title, color);
    }

    public HeadingOneBlock(String title, NotionColor color, boolean isToggleable) {
        this.HeadingOneContent = new HeadingOneContent(title, color, isToggleable);
    }

    public HeadingOneBlock(String title, boolean isToggleable) {
        this.HeadingOneContent = new HeadingOneContent(title, isToggleable);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class HeadingOneContent {

        private List<RichText> richText;

        private NotionColor color = NotionColor.DEFAULT;

        /**
         * 标题块是否为切换标题。若是,则标题块将切换并可以支持子项。否则则标题块是静态标题块
         */
        @JsonProperty("is_toggleable")
        private boolean isToggleable;


        public HeadingOneContent(String title) {
            this(Collections.singletonList(new RichText(title)), NotionColor.DEFAULT, false);
        }

        public HeadingOneContent(String title, NotionColor color) {
            this(Collections.singletonList(new RichText(title)), color, false);
        }

        public HeadingOneContent(String title, boolean isToggleable) {
            this(Collections.singletonList(new RichText(title)), NotionColor.DEFAULT, isToggleable);
        }

        public HeadingOneContent(String title, NotionColor color, boolean isToggleable) {
            this(Collections.singletonList(new RichText(title)), color, isToggleable);
        }
    }

}
