package com.minwei.test.model.emoji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * Notion emoji对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotionEmoji extends Emoji {


    /**
     * 表情符号字符
     */
    private String emoji;

}
