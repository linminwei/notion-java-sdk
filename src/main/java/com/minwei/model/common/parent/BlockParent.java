package com.minwei.model.common.parent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 块父级对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockParent extends Parent{

    private String blockId;

}
