package com.minwei.test.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 面包屑块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BreadcrumbBlock extends NotionBlock {

    private BreadcrumbContent breadcrumb;

    @Data
    @AllArgsConstructor
    private static class BreadcrumbContent {
    }

}
