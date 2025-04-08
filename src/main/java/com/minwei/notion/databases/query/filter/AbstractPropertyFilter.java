package com.minwei.notion.databases.query.filter;

public abstract class AbstractPropertyFilter {
    private String property;

    protected AbstractPropertyFilter(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
