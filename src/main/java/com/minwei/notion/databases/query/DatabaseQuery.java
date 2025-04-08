package com.minwei.notion.databases.query;

import com.minwei.notion.databases.query.filter.Filter;
import com.minwei.notion.databases.query.sort.*;
import com.minwei.utils.JsonUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库查询对象
 */
public class DatabaseQuery {
    private final List<SortObject> sorts;
    private final Filter filter;

    public DatabaseQuery(Filter filter) {
        this.sorts = new ArrayList<>();
        this.filter = filter;
    }

    public List<SortObject> getSorts() {
        return sorts;
    }

    public Filter getFilter() {
        return filter;
    }

    public void addSort(SortObject sortObject) {
        this.sorts.add(sortObject);
    }
    public void addPropertySort(String property, DirectionEnum direction) {
        PropertySort propertySort = new PropertySort();
        propertySort.setProperty(property);
        propertySort.setDirectionEnum(direction);
        this.sorts.add(propertySort);
    }
    public void addTimestampSort(TimestampEnum timestamp, DirectionEnum direction) {
        TimestampSort timestampSort = new TimestampSort();
        timestampSort.setTimestamp(timestamp);
        timestampSort.setDirectionEnum(direction);
        this.sorts.add(timestampSort);
    }

    public DatabaseQuery propertySort(String property, DirectionEnum direction) {
        this.addPropertySort(property, direction);
        return this;
    }
    public DatabaseQuery propertySortAsc(String ... properties) {
        for (String property : properties) {
            this.addPropertySort(property, DirectionEnum.ASCENDING);
        }
        return this;
    }
    public DatabaseQuery propertySortDesc(String ... properties) {
        for (String property: properties) {
            this.addPropertySort(property, DirectionEnum.DESCENDING);
        }
        return this;
    }

    public static void main(String[] args) {
        NotionIso8601Date notionIso8601Date = new NotionIso8601Date(ZonedDateTime.now(ZoneId.of("-01:00")));
        NotionIso8601Date notionIso8601Date1 = new NotionIso8601Date(LocalDate.now());
        NotionIso8601Date notionIso8601Date2 = new NotionIso8601Date(LocalDateTime.now());


        System.out.println(JsonUtil.toJson(notionIso8601Date1));
        System.out.println(JsonUtil.toJson(notionIso8601Date2));
        System.out.println(JsonUtil.toJson(notionIso8601Date));
    }

}
