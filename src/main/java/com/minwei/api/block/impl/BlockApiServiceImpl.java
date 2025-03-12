package com.minwei.api.block.impl;

import com.minwei.api.block.BlockApiService;
import com.minwei.client.NotionClient;
import com.minwei.http.request.block.AppendBlockChildrenRequest;
import com.minwei.http.response.NotionResponse;
import com.minwei.model.blocks.NotionBlock;
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
    public NotionResponse<NotionBlock> appendBlockChildren(String token, String blockId, AppendBlockChildrenRequest request) {

        String jsonBody = JsonUtil.toJson(request);

        String endpoint = "/blocks/" + blockId + "/children";

        NotionClient notionClient = new NotionClient(token);

        return notionClient.patch(endpoint, jsonBody, NotionBlock.class);
    }

    @Override
    public NotionResponse<NotionBlock> retrieveBlock(String token, String blockId) {

        String endpoint = "/blocks/" + blockId;

        NotionClient notionClient = new NotionClient(token);

        return notionClient.getWithoutNotionResponse(endpoint, NotionBlock.class);

    }

    @Override
    public NotionResponse<NotionBlock> retrieveBlockChildren(String token, String blockId) {

        String endpoint = "/blocks/" + blockId + "/children";

        NotionClient notionClient = new NotionClient(token);

        return notionClient.get(endpoint, NotionBlock.class);

    }
}
