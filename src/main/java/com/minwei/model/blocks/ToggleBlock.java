package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 折叠块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToggleBlock extends NotionBlock {

    private ToggleContent toggle;

    public ToggleBlock(String content) {
        this(new ToggleContent(Collections.singletonList(new RichText(content)), NotionColor.DEFAULT, null));
    }

    public ToggleBlock(String content, NotionColor color) {
        this(new ToggleContent(Collections.singletonList(new RichText(content)), color, null));
    }

    public ToggleBlock(String content, NotionColor color, List<NotionBlock> blocks) {
        this(new ToggleContent(Collections.singletonList(new RichText(content)), color, blocks));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ToggleContent {

        private List<RichText> richText;

        private NotionColor color;

        List<NotionBlock> children;
    }
}
