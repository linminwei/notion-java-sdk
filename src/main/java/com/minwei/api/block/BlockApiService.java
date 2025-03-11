package com.minwei.api.block;

import com.minwei.http.request.block.AppendBlockChildrenRequest;
import com.minwei.http.response.NotionResponse;
import com.minwei.model.blocks.NotionBlock;

/**
 * Notion API 服务
 *
 * @author lmw
 */
public interface BlockApiService {

    /**
     * 追加块子项
     *
     * @param token   token
     * @param blockId 块标识符,也接受页面id
     * @param request 追加块请求
     * @return 追加块响应
     */
    NotionResponse<NotionBlock> appendBlockChildren(String token, String blockId, AppendBlockChildrenRequest request);


    /**
     * 检索区块
     * @param blockId 块id
     * @return 检索区块响应
     */
    NotionBlock retrieveBlock(String token,String blockId);

}
