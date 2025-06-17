package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 数据库提及对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class MentionDatabase {

    @JsonProperty("database")
    private MentionDatabaseContent database;

    /**
     * 数据库提及对象内容
     */
    @Data
    public static class MentionDatabaseContent {

        /** 数据库ID **/
        @JsonProperty("id")
        private String id;

    }
}
