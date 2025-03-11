package com.minwei.model.blocks;

import com.minwei.enums.NotionCodeLanguage;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 代码块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeBlock extends NotionBlock {

    private CodeContent code;


    public CodeBlock(String caption, String richText, NotionCodeLanguage language) {
        this.code = new CodeContent(caption, richText, language);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CodeContent {

        /**
         * 代码块标题中的格式文本。
         */
        private List<RichText> caption;

        /**
         * 代码块中的富文本。
         */
        private List<RichText> richText;

        /**
         * 代码块中包含的代码的语言。
         */
        private NotionCodeLanguage language;


        public CodeContent(String caption, String richText, NotionCodeLanguage language) {
            this.caption = Collections.singletonList(new RichText(caption));
            this.richText = Collections.singletonList(new RichText(richText));
            this.language = language;
        }
    }

}
