package com.minwei.dto;

import lombok.Data;

/**
 * 添加书签块对象DTO
 * @author lmw
 */
@Data
public class AddBookMarkBlockDTO {

    /**
     * Notion业务实体
     */
    private Object object;

    /**
     * 所添加的目标页面
     */
    private String pageId;


    /**
     * 书签标题
     */
    private String caption;

    /**
     * 书签链接
     */
    private String url;
}
