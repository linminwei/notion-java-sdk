package com.minwei.api.request.page;


import com.minwei.api.request.NotionRequest;
import com.minwei.api.response.page.RetrievePageResponse;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Notion检索页面请求对象
 *
 * @author lmw 2025/09/08
 */
public class RetrievePageRequest implements NotionRequest<RetrievePageResponse> {

    // 页面ID
    private String pageId;

    // 与页面关联的属性值ID的列表,使用此参数将响应限制为特定页面属性值,若要检索多个属性,请指定每个页面属性ID
    private List<String> filterProperties;

    public RetrievePageRequest(String pageId) {
        this.pageId = pageId;
    }

    public RetrievePageRequest(String pageId, List<String> filterProperties) {
        this.pageId = pageId;
        this.filterProperties = filterProperties;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getReqUrl() {
        return "/pages/{page_id}";
    }

    @Override
    public Map<String, String> getPathParams() {

        if (pageId == null) {
            return Collections.emptyMap();
        }

        Map<String,String> pathParamsMap = new HashMap<>();
        pathParamsMap.put("page_id",pageId);
        return pathParamsMap;
    }

    @Override
    public MultiValueMap<String, String> getReqParams() {

        if (CollectionUtils.isEmpty(filterProperties)) {
            return new LinkedMultiValueMap<>();
        }

        MultiValueMap<String,String> reqParamsMap = new LinkedMultiValueMap<>();
        reqParamsMap.put("filter_properties",filterProperties);

        return reqParamsMap;
    }

    @Override
    public Object getReqBody() {
        return null;
    }

    @Override
    public Class<RetrievePageResponse> getResClass() {
        return RetrievePageResponse.class;
    }
}
