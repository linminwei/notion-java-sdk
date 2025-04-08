package com.minwei.notion.databases.query.filter;


import com.minwei.notion.databases.query.EmptyObject;
import com.minwei.notion.databases.query.NotionIso8601Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class DateFilter extends AbstractPropertyFilter {
    private Date date;

    public DateFilter(String property) {
        super(property);
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    @Accessors(chain = true)
    @Setter
    @Getter
    public class Date {
        private NotionIso8601Date after;
        private NotionIso8601Date before;
        private NotionIso8601Date equals;
        private Boolean isEmpty;
        private Boolean isNotEmpty;
        private EmptyObject nextMonth;
        private EmptyObject nextWeek;
        private EmptyObject nextYear;
        private NotionIso8601Date onOrAfter;
        private NotionIso8601Date onOrBefore;
        private EmptyObject pastMonth;
        private EmptyObject pastWeek;
        private EmptyObject pastYear;
        private EmptyObject thisWeek;
    }
}
