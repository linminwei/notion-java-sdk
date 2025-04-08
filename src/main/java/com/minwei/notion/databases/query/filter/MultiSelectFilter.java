package com.minwei.notion.databases.query.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class MultiSelectFilter extends AbstractPropertyFilter{
    private MultiSelect multiSelect;

    public MultiSelectFilter(String property) {
        super(property);
        this.multiSelect = new MultiSelect();
    }

    @Accessors(chain = true)
    @Setter
    @Getter
    public class MultiSelect {
        private String contains;
        private String doesNotContain;
        private Boolean isEmpty;
        private Boolean isNotEmpty;
    }
}
