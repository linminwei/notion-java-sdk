package com.minwei.model.blocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 方程块对象
 *
 * @author lmw
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
        private String expression;
    }

}
