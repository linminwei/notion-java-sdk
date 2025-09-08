package com.minwei.test.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 嵌入块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbedBlock extends NotionBlock {

    private EmbedContent embed;

    public EmbedBlock(String url) {
        this.embed = new EmbedContent(url);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class EmbedContent {
        String url;
    }

}
