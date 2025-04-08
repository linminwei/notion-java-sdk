package com.minwei.notion.databases.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NotionIso8601Date {
    private LocalDate localDate;
    private LocalDateTime localDateTime;
    private ZonedDateTime zonedDateTime;

    public NotionIso8601Date(LocalDate localDate) {
        this.localDate = localDate;
    }

    public NotionIso8601Date(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public NotionIso8601Date(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    @JsonValue
    public String getJsonValue() {
        if (localDate != null) return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        if (localDateTime != null) return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        if (zonedDateTime != null) return zonedDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return null;
    }

    @JsonCreator
    public NotionIso8601Date formJsonValue(String jsonValue) {
        throw new UnsupportedOperationException(NotionIso8601Date.class.getName() + "不支持反序列化:" + jsonValue);
    }
}
