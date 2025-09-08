package com.minwei.test.http.response;

import lombok.Data;

import java.util.List;

/**
 * Notion通用响应对象
 *
 * @author lmw
 */
@Data
public class NotionResponse<T> {

    /**
     * 对象类型,如 page、list、database
     */
    private String object;

    /**
     * 列表数据
     */
    private List<T> results;

    /**
     * 表示results中的对象类型
     */
    private String type;

    /**
     * 分页游标
     */
    private String nextCursor;

    /**
     * 是否还有更多数据
     */
    private boolean hasMore;

    private NotionErrorResponse notionErrorResponse;

}
