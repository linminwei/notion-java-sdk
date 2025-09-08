package com.minwei.test.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import notion.api.v1.model.common.PropertyType;

import java.util.Date;
import java.util.List;

/**
 * @author lmw
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {

    /**
     * 页面id
     */
    private String id;

    /**
     * 所属数据库id
     */
    private String databaseId;

    /**
     * icon
     */
    private String icon;

    /**
     * cover
     */
    private String cover;

    /**
     * 属性列表
     */
    private List<Property> properties;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


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
    }
}
