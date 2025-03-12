package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.richtext.RichText;
import com.minwei.model.common.richtext.text.Text;
import com.minwei.model.emoji.NotionEmoji;
import com.minwei.model.file.ExternalFile;
import com.minwei.model.icon.Icon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author lmw
 * 标注块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalloutBlock extends NotionBlock {

    private CalloutContent callout;

    public CalloutBlock(String content) {
        this.callout = new CalloutContent(content, null, null, NotionColor.DEFAULT);
    }

    public CalloutBlock(String content, NotionColor color) {
        this.callout = new CalloutContent(content, null, null, color);
    }

    public CalloutBlock(String content, String url, String emoji) {
        this.callout = new CalloutContent(content, url, emoji, NotionColor.DEFAULT);
    }

    public CalloutBlock(String content, String url, String emoji, NotionColor color) {
        this.callout = new CalloutContent(content, url, emoji, color);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CalloutContent {

        private List<RichText> richText;

        private Icon icon;

        private NotionColor color;

        public CalloutContent(String content, String url, String emoji, NotionColor color) {
            this.richText = Collections.singletonList(new Text(content));

            if (StringUtils.isNotBlank(url)) {
                this.icon = new ExternalFile(url);
            }
            if (StringUtils.isNotBlank(emoji)) {
                this.icon = new NotionEmoji(emoji);
            }

            this.color = color;
        }
    }

}
