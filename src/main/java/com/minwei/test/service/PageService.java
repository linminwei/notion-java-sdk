package com.minwei.test.service;

import com.minwei.test.vo.PageVo;

import java.util.List;

/**
 * @author lmw
 */
public interface PageService {

    /**
     * 创建单个页面
     *
     * @param object Notion业务实体
     * @param <T>    泛型
     * @return PageId
     */
    <T> String createPage(T object,String token,String databaseId);

    /**
     * 批量创建页面
     *
     * @param objects Notion业务实体集合
     * @param <T>     泛型
     * @return PageId集合
     */
    <T> List<String> batchCreatePage(List<T> objects,String token,String databaseId);


    /**
     * 根据id查询页面
     *
     * @param id    id
     * @param token token
     * @return PageVo
     */
    <T> T selectById(Class<T> clazz,String id, String token);

    /**
     * 根据id查询页面
     *
     * @param id    id
     * @param token token
     * @return PageVo
     */
    PageVo selectById(String id, String token);
}
