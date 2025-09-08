package com.minwei.api.request;


import com.minwei.api.response.NotionResponse;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * Notion请求对象
 *
 * @author lmw 2025/09/08
 */
public interface NotionRequest<T extends NotionResponse> {

    // 请求方法
    HttpMethod getMethod();

    // 请求路径
    String getReqUrl();

    // 路径参数
    Map<String,String> getPathParams();

    // 请求参数
    MultiValueMap<String,String> getReqParams();

    // 请求体
    Object getReqBody();

    // 响应对象类型
    Class<T> getResClass();

}
