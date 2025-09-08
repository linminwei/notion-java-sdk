package com.minwei.test.model.blocks;

import com.minwei.test.enums.NotionCodeLanguage;
import com.minwei.test.model.common.richtext.RichText;
import com.minwei.test.model.common.richtext.text.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author lmw
 * 代码块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeBlock extends NotionBlock {

    private CodeContent code;

    public CodeBlock(String title, String text, NotionCodeLanguage codeLanguage) {
        this.code = new CodeContent(Collections.singletonList(new Text(title)), Collections.singletonList(new Text(title)), codeLanguage);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CodeContent {

        /**
         * 代码块标题
         */
        private List<RichText> caption;

        /**
         * 代码块中的富文本
         */
        private List<RichText> richText;

        /**
         * 代码块语言
         */
        private NotionCodeLanguage language;

    }

}
