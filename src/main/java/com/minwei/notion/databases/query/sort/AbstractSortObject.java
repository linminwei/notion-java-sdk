package com.minwei.notion.databases.query.sort;

public abstract class AbstractSortObject implements SortObject{
    protected DirectionEnum directionEnum;

    public DirectionEnum getDirectionEnum() {
        return directionEnum;
    }

    public void setDirectionEnum(DirectionEnum directionEnum) {
        this.directionEnum = directionEnum;
    }
}
