package com.minwei.test.model.common.richtext.text;

import com.minwei.test.model.common.richtext.Link;
import com.minwei.test.model.common.richtext.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 富文本对象实例
 * 普通文本对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text extends RichText {

    private TextContent text;

    public Text(String content) {
        this.text = new TextContent(content, null);
    }

    public Text(String content, String link) {
        this.text = new TextContent(content, new Link(link));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TextContent {

        private String content;

        private Link link;
    }

}
