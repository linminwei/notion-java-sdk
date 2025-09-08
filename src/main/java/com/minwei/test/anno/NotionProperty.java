package com.minwei.test.anno;

import notion.api.v1.model.common.PropertyType;

import java.lang.annotation.*;

/**
 * @author lmw
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface NotionProperty {

    /**
     * 属性名
     *
     * @return String
     */
    String name();

    /**
     * 属性类型
     *
     * @return PropertyType
     */
    PropertyType type();

    /**
     * 是否指定为icon，若指定该属性，则会将该字段的值作为icon的URL路径
     *
     * @return Boolean
     */
    boolean isIcon() default false;

    /**
     * 是否设定为封面，若指定该属性，则会将字段的值作为封面的URL路径
     *
     * @return Boolean
     */
    boolean isCover() default false;
}
