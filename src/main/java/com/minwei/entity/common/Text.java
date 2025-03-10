package com.minwei.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 普通文本对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    private String content;
    private String link;

    public Text(String content) {
        this(content, null);
    }
}
