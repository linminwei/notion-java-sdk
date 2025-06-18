package com.minwei.notion.model.property;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 更新时间属性
 *
 * @author lmw 2025/06/18
 */
@Data
public class LastEditedTime implements Property {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "last_edited_time";

    @JsonProperty("last_edited_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date lastEditedTime;

}
