package com.minwei.model.request.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.entity.block.Block;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 附加块子项请求
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppendBlockChildrenRequest {

    /**
     * 块对象集合
     */
    @JsonProperty("children")
    private List<Block> children;
}
