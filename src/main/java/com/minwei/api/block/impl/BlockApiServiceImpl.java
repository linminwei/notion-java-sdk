package com.minwei.api.block.impl;

import com.minwei.api.block.BlockApiService;
import com.minwei.client.NotionClient;
import com.minwei.entity.block.Block;
import com.minwei.model.request.block.AppendBlockChildrenRequest;
import com.minwei.model.response.NotionResponse;
import com.minwei.utils.JsonUtil;
import org.springframework.stereotype.Service;

/**
 * Notion API 服务实现类
 *
 * @author lmw
 */
@Service
public class BlockApiServiceImpl implements BlockApiService {

    @Override
    public <T extends Block> NotionResponse<Block> appendBlockChildren(String token, String blockId, AppendBlockChildrenRequest request) {

        String jsonBody = JsonUtil.toJson(request);

        String endpoint = "/blocks/" + blockId + "/children";

        NotionClient notionClient = new NotionClient(token);

        return notionClient.patch(endpoint, jsonBody, Block.class);
    }
}
