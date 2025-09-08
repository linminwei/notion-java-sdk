package com.minwei.test.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 方程块对象
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquationBlock extends NotionBlock {

    private EquationContent equation;

    public EquationBlock(String expression) {
        this.equation = new EquationContent(expression);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class EquationContent {
        /**
         * 一个 KaTeX 兼容的字符串
         */
        String expression;
    }

}
