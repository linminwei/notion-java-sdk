package com.minwei.model.common.richtext.mention;

import com.minwei.model.common.richtext.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 富文本提及对象
 * 提及对象表示数据库、日期、链接预览提及、页面、模板提及或用户的内联提及
 *
 * @author lmw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mention extends RichText {

    private MentionAbstract mention;

}
