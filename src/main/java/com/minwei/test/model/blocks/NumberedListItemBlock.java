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
 * 编号列表项块
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberedListItemBlock extends NotionBlock {

    private NumberedListItemContent numberedListItem;

    public NumberedListItemBlock(String content) {
        this.numberedListItem = new NumberedListItemContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, null);
    }

    public NumberedListItemBlock(String content, NotionColor color) {
        this.numberedListItem = new NumberedListItemContent(Collections.singletonList(new Text(content)), color, null);
    }

    public NumberedListItemBlock(String content, List<NotionBlock> blocks) {
        this.numberedListItem = new NumberedListItemContent(Collections.singletonList(new Text(content)), NotionColor.DEFAULT, blocks);
    }

    public NumberedListItemBlock(String content, NotionColor color, List<NotionBlock> blocks) {
        this.numberedListItem = new NumberedListItemContent(Collections.singletonList(new Text(content)), color, blocks);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class NumberedListItemContent {

        List<RichText> richText;

        NotionColor color;

        List<NotionBlock> children;

    }


}
