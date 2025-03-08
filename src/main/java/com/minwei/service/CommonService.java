package com.minwei.service;

import com.minwei.vo.NotionConfigVo;
import com.minwei.vo.NotionPropertyConfigVo;
import notion.api.v1.NotionClient;

import java.util.List;

/**
 * Notion通用服务接口
 * @author lmw
 */
public interface CommonService {

    /**
     * 获取Notion客户端
     * @param token token
     * @return NotionClient
     */
    NotionClient getNotionClient(String token);

    /**
     * 获取Notion配置
     * @param object Notion业务实体
     * @return NotionConfigVo Notion配置
     */
    NotionConfigVo getNotionConfig(Object object);

    /**
     * 获取Notion属性配置
     * @param object Notion业务实体
     * @return List<NotionPropertyConfigVo> Notion属性配置集
     * @param <T> 泛型
     */
    <T> List<NotionPropertyConfigVo> getNotionPropertyConfig(T object);




}
