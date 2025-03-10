package com.minwei.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注释对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annotation {

    /**
     * 粗体
     */
    private boolean bold;

    /**
     * 斜体
     */
    private boolean italic;

    /**
     * 删除线
     */
    private boolean strikethrough;

    /**
     * 下划线
     */
    private boolean underline;

    /**
     * 代码块
     */
    private boolean code;
    /**
     * 颜色
     */
    private String color;
}
