package com.minwei.test.model.page.properties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minwei.test.enums.TimeZone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lmw
 * 日期属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateProperty {

    /**
     * 开始时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date start;

    /**
     * 结束时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date end;

    /**
     * 时区
     */
    private TimeZone timezone;
}
