package com.minwei.test.notion.model.property;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 数字属性
 *
 * @author lmw 2025/06/18
 */
@Data
public class Number implements Property {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "number";

    @JsonProperty("number")
    private BigDecimal number;




}
