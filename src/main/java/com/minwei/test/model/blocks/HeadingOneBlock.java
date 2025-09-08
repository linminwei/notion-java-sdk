package com.minwei.test.model.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * h1标题块
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadingOneBlock extends NotionBlock {

    @JsonProperty("heading_1")
    private HeadingOneContent headingOne;

    public HeadingOneBlock(String content) {
        this.headingOne = new HeadingOneContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, false);
    }

    public HeadingOneBlock(String content, NotionColor color) {
        this.headingOne = new HeadingOneContent(Collections.singletonList(new Text(content)), color, false);
    }

    public HeadingOneBlock(String content, boolean isToggleable) {
        this.headingOne = new HeadingOneContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, isToggleable);
    }

    public HeadingOneBlock(String content, NotionColor color, boolean isToggleable) {
        this.headingOne = new HeadingOneContent(Collections.singletonList(new Text(content)), color, isToggleable);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class HeadingOneContent {

        private List<RichText> richText;

        private NotionColor color;

        /**
         * 是否为切换标题块,若是,标题块将切换且可支持子项
         */
        @JsonProperty("is_toggleable")
        private boolean isToggleable;
    }

}
