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
 * 标题属性
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleProperty extends AbstractProperty{

    private List<RichText> title;

    public TitleProperty(String title) {
        this.title = Collections.singletonList(new Text(title));
    }
}
