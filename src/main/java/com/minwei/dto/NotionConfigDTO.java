package com.minwei.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import notion.api.v1.model.common.PropertyType;

import java.util.List;

/**
 * @author lmw
 * Notion业务实体配置对象
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotionConfigDTO {

    /**
     * 数据库id
     */
    private String databaseId;

    /**
     * token
     */
    private String token;

    /**
     * 属性列表
     */
    private List<Property> properties;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Property {

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
}
