package com.minwei.test.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 分割线块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DividerBlock extends NotionBlock {

    private DividerContent divider;


    @Data
    @AllArgsConstructor
    private static class DividerContent {

    }

}
