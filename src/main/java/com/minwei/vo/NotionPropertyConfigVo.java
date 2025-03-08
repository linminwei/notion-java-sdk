package com.minwei.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import notion.api.v1.model.common.PropertyType;

/**
 * @author lmw
 * Notion属性配置
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotionPropertyConfigVo {

    /**
     * 属性名
     */
    private String propertyName;

    /**
     * 属性类型
     */
    private PropertyType propertyType;


    /**
     * 属性值
     */
    private Object value;

    /**
     * 是否为Icon
     */
    private Boolean isIcon;

    /**
     * 是否为Cover
     */
    private Boolean isCover;
}
