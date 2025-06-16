package com.minwei.notion.model.parent;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 块父对象
 *
 * @author lmw 2025/06/16
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BlockParent extends Parent{

    /** 块ID **/
    @JsonProperty("block_id")
    protected String blockId;
}
