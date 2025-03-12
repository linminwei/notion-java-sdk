package com.minwei.model.common.richtext.mention;

import com.minwei.model.properties.DateProperty;
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
