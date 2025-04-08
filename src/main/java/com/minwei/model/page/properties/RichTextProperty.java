package com.minwei.model.page.properties;

import com.minwei.model.common.richtext.RichText;
import com.minwei.model.common.richtext.text.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author lmw
 * 富文本属性
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RichTextProperty {

    List<RichText> richText;

    public RichTextProperty(String text) {
        this.richText = Collections.singletonList(new Text(text));
    }

}
