package com.minwei.model.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * h3标题块
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadingThreeBlock extends NotionBlock {

    @JsonProperty("heading_3")
    private HeadingThreeContent headingOne;

    public HeadingThreeBlock(String content) {
        this.headingOne = new HeadingThreeContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, false);
    }

    public HeadingThreeBlock(String content, NotionColor color) {
        this.headingOne = new HeadingThreeContent(Collections.singletonList(new Text(content)), color, false);
    }

    public HeadingThreeBlock(String content, boolean isToggleable) {
        this.headingOne = new HeadingThreeContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, isToggleable);
    }

    public HeadingThreeBlock(String content, NotionColor color, boolean isToggleable) {
        this.headingOne = new HeadingThreeContent(Collections.singletonList(new Text(content)), color, isToggleable);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class HeadingThreeContent {

        private List<RichText> richText;

        private NotionColor color;

        /**
         * 是否为切换标题块,若是,标题块将切换且可支持子项
         */
        @JsonProperty("is_toggleable")
        private boolean isToggleable;
    }

}
