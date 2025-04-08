package com.minwei.notion.databases.query.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class PeopleFilter extends AbstractPropertyFilter{
    private People people;
    public PeopleFilter(String property) {
        super(property);
        this.people = new People();
    }

    @Accessors(chain = true)
    @Setter
    @Getter
    public class People {
        private String contains;
        private String doesNotContain;
        private Boolean isEmpty;
        private Boolean isNotEmpty;
    }
}
