package com.minwei.model.common.richtext;

import com.minwei.enums.NotionColor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 注释对象
 * 用于设置富文本样式
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annotation {
    /**
     * 文本是否为粗体
     */
    private boolean bold;

    /**
     * 文本是否为斜体
     */
    private boolean italic;

    /**
     * 文本是否被删除
     */
    private boolean strikethrough;

    /**
     * 文本是否带有下划线
     */
    private boolean underline;

    /**
     * 文本是否为代码块
     */
    private boolean code;

    /**
     * 文本颜色
     */
    private NotionColor color;
}
