package com.minwei.model.common.parent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 页面父级对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParent extends Parent {

    /**
     * 页面id
     */
    private String pageId;

}
