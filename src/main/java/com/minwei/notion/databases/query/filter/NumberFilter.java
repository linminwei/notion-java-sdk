package com.minwei.notion.databases.query.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

public class NumberFilter extends AbstractPropertyFilter{
    private Number number;
    public NumberFilter(String property) {
        super(property);

    }
    @Accessors(chain = true)
    @Setter
    @Getter
    public class Number {
        private BigDecimal doesNotEqual;
        private BigDecimal equals;
        private BigDecimal greaterThan;
        private BigDecimal greaterThanOrEqualTo;
        private Boolean isEmpty;
        private Boolean isNotEmpty;
        private BigDecimal lessThan;
        private BigDecimal lessThanOrEqualTo;
    }
}
