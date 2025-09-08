package com.minwei.test.model.common.richtext.mention;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 链接预览提及类型对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentionLinkPreview extends MentionAbstract {

    private MentionLinkPreviewContent linkPreview;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class MentionLinkPreviewContent {
        String url;
    }

}
