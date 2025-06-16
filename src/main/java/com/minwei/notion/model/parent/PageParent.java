package com.minwei.notion.model.parent;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 页面父对象
 *
 * @author lmw 2025/06/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageParent extends Parent{

    /** 页面ID **/
    @JsonProperty("page_id")
    private String pageId;
}
