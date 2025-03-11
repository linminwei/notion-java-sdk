package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 注解块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalloutBlock extends NotionBlock {

    private CalloutContent callout;

    public CalloutBlock(List<String> contents) {
        this.callout = new CalloutContent(contents);
    }

    public CalloutBlock(List<String> contents, NotionColor color) {
        this.callout = new CalloutContent(contents, color);
    }

    @Data
    @NoArgsConstructor
    private static class CalloutContent {
        private List<RichText> richText;

        private NotionColor color = NotionColor.DEFAULT;

        public CalloutContent(List<String> contents) {
            this.richText = contents.stream().map(RichText::new).collect(Collectors.toList());
        }

        public CalloutContent(List<String> contents, NotionColor color) {
            this.richText = contents.stream().map(RichText::new).collect(Collectors.toList());
            this.color = color;
        }

    }

}
