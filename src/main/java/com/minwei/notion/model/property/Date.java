package com.minwei.notion.model.property;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 日期属性对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class Date implements Property {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "date";

    @JsonProperty("date")
    private DateInfo dateInfo;

    @Data
    public static class DateInfo {

        @JsonProperty("end")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
        private java.util.Date end;

        @JsonProperty("start")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
        private java.util.Date start;

    }

}
