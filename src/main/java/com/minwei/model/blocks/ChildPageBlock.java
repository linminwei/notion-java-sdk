package com.minwei.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 子页面块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildPageBlock extends NotionBlock {

    private ChildPageContent childPage;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ChildPageContent {
        private String title;
    }

}
