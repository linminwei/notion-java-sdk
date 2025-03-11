package com.minwei.model.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 富文本对象
 *
 * @author lmw
 */

@Data
@RequiredArgsConstructor
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
