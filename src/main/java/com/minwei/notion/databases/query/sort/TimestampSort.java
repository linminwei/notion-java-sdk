package com.minwei.notion.databases.query.sort;

public class TimestampSort extends AbstractSortObject{
    private TimestampEnum timestamp;

    public TimestampEnum getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(TimestampEnum timestamp) {
        this.timestamp = timestamp;
    }
}
