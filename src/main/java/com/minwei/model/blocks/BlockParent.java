package com.minwei.model.blocks;

import lombok.Data;

/**
 * Notion块父节点
 *
 * @author lmw
 */
@Data
public class BlockParent {
    private String type;
    private String blockId;
    private String pageId;
}
