package com.minwei.model.common;

import com.minwei.enums.NotionColor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注释对象
 *
 * @author lmw
 */
@Data
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
    private NotionColor color = NotionColor.DEFAULT;


    public Annotation(boolean bold) {
        this.bold = bold;
    }

    public Annotation(boolean bold, boolean italic) {
        this.bold = bold;
        this.italic = italic;
    }

    public Annotation(boolean bold, boolean italic, boolean strikethrough) {
        this.bold = bold;
        this.italic = italic;
        this.strikethrough = strikethrough;
    }

    public Annotation(boolean bold, boolean italic, boolean strikethrough, boolean underline) {
        this.bold = bold;
        this.italic = italic;
        this.strikethrough = strikethrough;
        this.underline = underline;
    }

    public Annotation(boolean bold, boolean italic, boolean strikethrough, boolean underline, boolean code) {
        this.bold = bold;
        this.italic = italic;
        this.strikethrough = strikethrough;
        this.underline = underline;
        this.code = code;
    }

    public Annotation(boolean bold, boolean italic, boolean strikethrough, boolean underline, boolean code, NotionColor color) {
        this.bold = bold;
        this.italic = italic;
        this.strikethrough = strikethrough;
        this.underline = underline;
        this.code = code;
        this.color = color;
    }

    public Annotation(NotionColor color) {
        this.color = color;
    }
}
