package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 链接预览提及对象
 *
 * @author lmw 2025/06/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MentionLinkPreview extends Mention {

    @JsonProperty("link_preview")
    private MentionLinkPreviewContent linkPreview;


    /**
     * 链接预览提及对象内容
     */
    @Data
    public static class MentionLinkPreviewContent {

        /** url **/
        @JsonProperty("url")
        private String url;

    }

}
