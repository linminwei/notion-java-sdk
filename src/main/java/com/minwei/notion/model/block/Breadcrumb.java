package com.minwei.notion.model.block;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 面包屑块
 *
 * @author lmw 2025/06/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Breadcrumb extends Block {


    @JsonProperty("breadcrumb")
    private BreadcrumbContent breadcrumb;


    /**
     * 面包屑块对象内容,在属性中不包含任何信息
     */
    @Data
    public static class BreadcrumbContent {}
}
