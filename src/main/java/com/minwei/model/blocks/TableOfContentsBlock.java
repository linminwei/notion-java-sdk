package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableOfContentsBlock extends NotionBlock {

    private TableOfContentsContent tableOfContents;

    public TableOfContentsBlock(NotionColor color) {
        this.tableOfContents = new TableOfContentsContent(color);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TableOfContentsContent {

        private NotionColor color;
    }

}
