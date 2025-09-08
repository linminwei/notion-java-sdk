package com.minwei.test.notion.model.property;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 多选属性
 *
 * @author lmw 2025/06/18
 */
@Data
public class MultiSelect implements Property {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "multi_select";

    @Data
    public static class MultiSelectInfo {

        /** 选项的颜色 **/
        @JsonProperty("color")
        private String color;

        /** 选项的唯一标识 **/
        @JsonProperty("id")
        private String id;

        /** 在Notion中显示的选项名 **/
        @JsonProperty("name")
        private String name;

    }
}
