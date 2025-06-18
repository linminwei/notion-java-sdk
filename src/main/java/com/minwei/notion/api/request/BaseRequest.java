package com.minwei.notion.api.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minwei.notion.api.response.BaseResponse;
import org.springframework.http.HttpMethod;

import java.util.Map;

/**
 * 基础请求对象
 *
 * @author lmw 2025/06/18
 */
public interface BaseRequest<T extends BaseResponse> {

    /**
     * 获取请求方式
     * @return HttpMethod
     */
    HttpMethod getMethod();

    /**
     * 获取端点
     * @return String
     */
    String getEndpoint();

    /**
     * 请求体
     */
    @JsonIgnore
    Object getRequestBody();

    /**
     * 路径参数
     */
    Map<String,String> getQueryParams();

    /**
     * 响应对象类型
     */
    Class<T> getResponseClass();
}
