package com.minwei.api.block;

import com.minwei.entity.block.Block;
import com.minwei.model.request.block.AppendBlockChildrenRequest;
import com.minwei.model.response.NotionResponse;

/**
 * Notion API 服务
 *
 * @author lmw
 */
public interface BlockApiService {

    <T extends Block> NotionResponse<Block> appendBlockChildren(String token, String blockId, AppendBlockChildrenRequest request);

}
