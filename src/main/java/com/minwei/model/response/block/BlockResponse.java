package com.minwei.model.response.block;

import com.minwei.entity.block.Block;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 块响应对象，表示 Notion API 返回的块信息。
 * 直接实现 Block 接口，继承多态特性。
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockResponse implements Block {

    private String id;

    private String object;

    private String type;

    private Object properties;
}
