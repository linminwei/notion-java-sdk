package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 内联 LaTeX 方程对象
*
* @author lmw 2025/06/18
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class Equation extends RichText {

    @JsonProperty("equation")
    private EquationContent equation;


    @Data
    public static class EquationContent {

        /** 内联方程的LaTeX字符串 **/
        @JsonProperty("expression")
        private String expression;
    }
}
