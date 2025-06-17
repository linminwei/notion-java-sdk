package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 页面提及对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class MentionPage {

    @JsonProperty("page")
    private MentionPageContent page;

    /**
     * 页面提及对象内容
     */
    @Data
    public static class MentionPageContent {

        /** 页面ID **/
        @JsonProperty("id")
        private String id;

    }
}
