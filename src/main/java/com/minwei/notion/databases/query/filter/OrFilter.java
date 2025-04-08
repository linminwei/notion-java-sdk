package com.minwei.notion.databases.query.filter;

import java.util.ArrayList;
import java.util.List;

public class OrFilter implements Filter {
    private final List<Filter> or;
    public OrFilter() {
        or = new ArrayList<>();
    }

    public List<Filter> getAnd() {
        return or;
    }

    public void addFilter(Filter filter) {
        this.or.add(filter);
    }
}
