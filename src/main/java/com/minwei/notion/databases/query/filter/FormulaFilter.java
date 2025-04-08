package com.minwei.notion.databases.query.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class FormulaFilter extends AbstractPropertyFilter {
    private Formula formula;

    public FormulaFilter(String property) {
        super(property);
    }

    @Accessors(chain = true)
    @Setter
    @Getter
    public class Formula {
        private CheckboxFilter checkbox;
        private DateFilter date;
        private Object number;
        private String string;
    }
}
