package com.minwei.model.common.richtext.equation;

import com.minwei.model.common.richtext.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 富文本方程对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equation extends RichText {

    private EquationContent equation;

    public Equation(String expression) {
        this.equation = new EquationContent(expression);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class EquationContent {
        /**
         * 表示内联方程的 LaTeX 字符串
         */
        private String expression;
    }


}
