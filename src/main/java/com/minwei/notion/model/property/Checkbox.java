package com.minwei.notion.model.property;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 复选框属性对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class Checkbox {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "checkbox";

    private Boolean checkbox;
}
