package com.minwei.test.notion.model.property;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 创建时间属性对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class CreatedTime implements Property {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "created_time";

    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date createdTime;
}
