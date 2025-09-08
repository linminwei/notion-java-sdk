package com.minwei.test.api;

import com.minwei.test.http.request.block.AppendBlockChildrenRequest;
import com.minwei.test.http.response.NotionResponse;
import com.minwei.test.model.blocks.NotionBlock;

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
     *
     * @param blockId 块id
     * @return 检索区块响应
     */
    NotionResponse<NotionBlock> retrieveBlock(String token, String blockId);


    /**
     * 检索块子项
     * 使用指定id返回包含的子块对象分页数组
     *
     * @param token token
     * @param blockId 块id
     * @return 检索块子项响应
     */
    NotionResponse<NotionBlock> retrieveBlockChildren(String token, String blockId);


    /**
     * 删除块
     * @param token token
     * @param blockId 块id
     * @return 删除块响应
     */
    NotionResponse<NotionBlock> deleteBlock(String token, String blockId);

}
