package com.minwei.test.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 子数据块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildDatabaseBlock extends NotionBlock {


    private ChildDatabaseContent childDatabase;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ChildDatabaseContent {
        private String title;
    }

}
