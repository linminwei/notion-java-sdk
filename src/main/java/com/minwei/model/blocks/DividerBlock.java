package com.minwei.model.blocks;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 分割线块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
public class DividerBlock extends NotionBlock {

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private DividerBlock.DividerContent divider;


    public DividerBlock() {
        this.divider = new DividerBlock.DividerContent();
    }


    private static class DividerContent {
    }
}
