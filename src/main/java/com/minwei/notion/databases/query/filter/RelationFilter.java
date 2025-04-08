package com.minwei.notion.databases.query.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class RelationFilter extends AbstractPropertyFilter{
    private Relation relation;

    public RelationFilter(String property) {
        super(property);
    }

    @Accessors(chain = true)
    @Setter
    @Getter
    public class Relation {
        private String contains;
        private String doesNotContain;
        private Boolean isEmpty;
        private Boolean isNotEmpty;
    }
}
