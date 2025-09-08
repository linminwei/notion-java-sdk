package com.minwei.test.model.common.richtext.mention;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库提及类型对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentionDatabase extends MentionAbstract {

    private MentionDatabaseContent database;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class MentionDatabaseContent {
        private String id;
    }

}
