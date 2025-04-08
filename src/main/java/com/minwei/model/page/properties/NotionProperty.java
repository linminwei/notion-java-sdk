package com.minwei.model.page.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotionProperty {

    /**
     * 属性基础标识符
     */
    private String id;

    /**
     * 属性类型
     */
    private String type;


    /**
     * 属性值抽象
     */
    private AbstractProperty property;
}
