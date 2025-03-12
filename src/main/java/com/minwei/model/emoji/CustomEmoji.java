package com.minwei.model.emoji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 自定义表情符号
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomEmoji extends Emoji {

    /**
     * 自定义emoji对象内容
     */
    private CustomEmojiContent customEmoji;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CustomEmojiContent {
        private String id;
        private String name;
        private String url;
    }
}
