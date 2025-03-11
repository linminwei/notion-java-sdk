package com.minwei.model.blocks;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 面包屑块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
public class BreadcrumbBook extends NotionBlock {

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private BreadcrumbContent breadcrumb;


    public BreadcrumbBook() {
        this.breadcrumb = new BreadcrumbContent();
    }

    private static class BreadcrumbContent {
    }
}
