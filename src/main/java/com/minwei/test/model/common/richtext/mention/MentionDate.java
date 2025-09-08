package com.minwei.test.model.common.richtext.mention;

import com.minwei.test.model.page.properties.DateProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日期提及类型对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentionDate extends MentionAbstract {

    private DateProperty date;

}
