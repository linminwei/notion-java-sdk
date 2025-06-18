package com.minwei.notion.api.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.notion.api.response.RetrievePageResponse;
import lombok.Data;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * 检索页面请求对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class RetrievePageRequest implements BaseRequest<RetrievePageResponse>{

    @JsonProperty("page_id")
    private String pageId;

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getEndpoint() {
        return "/pages/{page_id}";
    }

    @Override
    public Object getRequestBody() {
        return null;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String,String> params = new HashMap<>();
        params.put("page_id", pageId);
        return params;
    }

    @Override
    public Class<RetrievePageResponse> getResponseClass() {
        return RetrievePageResponse.class;
    }
}
