package com.minwei.anno;

import java.lang.annotation.*;

/**
 * @author lmw
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface NotionConfig {

    /**
     * 数据库id
     *
     * @return String
     */
    String databaseId();

    /**
     * token
     *
     * @return String
     */
    String token();

}
