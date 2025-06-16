package com.minwei.notion.model.parent;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据库父对象
 *
 * @author lmw 2025/06/16
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class DatabaseParent extends Parent{

    /** 数据库ID **/
    @JsonProperty("database_id")
    private String databaseId;
}
