package com.minwei.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import notion.api.v1.model.common.PropertyType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotionPropertyConfigDTO {

    /**
     * 属性名
     */
    private String name;

    /**
     * 属性类型
     */
    private PropertyType type;

    /**
     * 属性值
     */
    private Object value;

    /**
     * 是否为icon
     */
    private Boolean isIcon;

    /**
     * 是否为cover
     */
    private Boolean isCover;

}
