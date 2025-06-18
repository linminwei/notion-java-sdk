package com.minwei.notion.model.property;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lmw 2025/06/18
 */
@Data
public class Email implements Property {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "email";

    @JsonProperty("email")
    private String email;

}
