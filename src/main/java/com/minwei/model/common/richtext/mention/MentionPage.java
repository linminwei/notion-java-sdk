package com.minwei.model.common.richtext.mention;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 页面提及类型对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentionPage extends MentionAbstract {

    private MentionPageContent page;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class MentionPageContent {
        String id;
    }

}
