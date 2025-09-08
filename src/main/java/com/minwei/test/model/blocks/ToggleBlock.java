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
 * 切换块
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToggleBlock extends NotionBlock {

    private ToggleContent toggle;

    public ToggleBlock(String content) {
        this.toggle = new ToggleContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, null);
    }

    public ToggleBlock(String content, NotionColor color) {
        this.toggle = new ToggleContent(Collections.singletonList(new Text(content)), color, null);
    }

    public ToggleBlock(String content, List<NotionBlock> blocks) {
        this.toggle = new ToggleContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, blocks);
    }

    public ToggleBlock(String content, NotionColor color, List<NotionBlock> blocks) {
        this.toggle = new ToggleContent(Collections.singletonList(new Text(content)), color, blocks);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ToggleContent {

        private List<RichText> richText;

        private NotionColor color;

        private List<NotionBlock> children;

    }


}
