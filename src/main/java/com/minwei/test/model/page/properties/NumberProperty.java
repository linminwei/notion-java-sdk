package com.minwei.test.model.page.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 数字属性值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberProperty extends AbstractProperty {

    private NumberContent content;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class NumberContent {
        private Integer number;
    }

}
