package com.minwei.test.api.impl;

import com.minwei.test.api.BlockApiService;
import com.minwei.test.client.NotionClient;
import com.minwei.test.http.request.block.AppendBlockChildrenRequest;
import com.minwei.test.http.response.NotionResponse;
import com.minwei.test.model.blocks.NotionBlock;
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

//        String jsonBody = JsonUtil.toJson(request);

        String endpoint = "/blocks/" + blockId + "/children";

        NotionClient notionClient = new NotionClient(token);

//        return notionClient.patch(endpoint, jsonBody, NotionBlock.class);
        return null;
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

    @Override
    public NotionResponse<NotionBlock> deleteBlock(String token, String blockId) {
        return null;
    }
}
