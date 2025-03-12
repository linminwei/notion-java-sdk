package com.minwei.model.common.parent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库父级对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseParent extends Parent {

    /**
     * 数据库id
     */
    private String databaseId;
}
