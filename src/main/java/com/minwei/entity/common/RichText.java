package com.minwei.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 富文本对象
 *
 * @author lmw
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RichText {

    private final String type = "text";

    private Text text;

    private Annotation annotations;

    private String plainText;

    private String href;


    public RichText(String content) {
        this.text = new Text(content);
    }

}
