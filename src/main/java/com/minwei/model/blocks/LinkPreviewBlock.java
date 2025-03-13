package com.minwei.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 链接预览块
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkPreviewBlock extends NotionBlock {

    private LinkPreviewContent linkPreview;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class LinkPreviewContent {

        private String url;

    }

}
