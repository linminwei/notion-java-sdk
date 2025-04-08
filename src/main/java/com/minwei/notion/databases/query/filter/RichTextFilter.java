package com.minwei.notion.databases.query.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class RichTextFilter extends AbstractPropertyFilter{
    private RichText richText;
    public RichTextFilter(String property) {
        super(property);
        this.richText = new RichText();
    }

    @Accessors(chain = true)
    @Setter
    @Getter
    public class RichText {
        private String contains;
        private String doesNotContain;
        private Boolean isEmpty;
        private Boolean isNotEmpty;
    }
}
