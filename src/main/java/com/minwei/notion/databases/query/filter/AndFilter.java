package com.minwei.notion.databases.query.filter;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter {
    private final List<Filter> and;
    public AndFilter() {
        and = new ArrayList<>();
    }

    public List<Filter> getAnd() {
        return and;
    }

    public void addFilter(Filter filter) {
        this.and.add(filter);
    }
}
