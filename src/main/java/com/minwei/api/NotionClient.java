package com.minwei.api;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minwei.api.request.NotionRequest;
import com.minwei.api.response.NotionResponse;
import com.minwei.enums.NotionErrorCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * Notion客户端
 *
 * @author lmw 2025/09/08
 */
public class NotionClient {

    private String token;

    private final OkHttpClient client;

    private final ObjectMapper mapper;

    private final String BASE_URL = "https://api.notion.com/v1";

    private final String NOTION_VERSION = "2025-09-03";

    public NotionClient(String token) {
        this.token = token;
        this.client = new OkHttpClient.Builder().build();
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }


    public <T extends NotionResponse> T execute(NotionRequest<T> request) {
        // 请求方法
        HttpMethod reqMethod = request.getMethod();
        // 请求路径
        String reqUrl = request.getReqUrl();
        // 路径参数
        Map<String, String> pathParams = request.getPathParams();
        // 请求参数
        MultiValueMap<String, String> reqParams = request.getReqParams();
        // 请求体
        Object reqBody = request.getReqBody();
        // 响应对象类型
        Class<T> resClass = request.getResClass();

        // 构建完整请求路径
        String fullUrl = BASE_URL + reqUrl;
        if (!CollectionUtils.isEmpty(pathParams)) {
            // 路径参数不为空,替换
            fullUrl = UriComponentsBuilder.fromHttpUrl(fullUrl)
                    .buildAndExpand(pathParams)
                    .toUriString();
        }
        if (!CollectionUtils.isEmpty(reqParams)) {
            // 查询参数不为空,拼接
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(fullUrl);
            reqParams.forEach((k,v) -> {
                if (!CollectionUtils.isEmpty(v)) {
                    uriBuilder.queryParam(k,v);
                }
            });
            fullUrl = uriBuilder.toUriString();
        }

        // 构建请求
        Request httpRequest = buildRequest(reqMethod, fullUrl, reqBody);

        // 执行请求并处理响应
        try (Response response = client.newCall(httpRequest).execute()) {

            String resultStr = response.body().string();

            T result = mapper.readValue(resultStr, resClass);
            result.setSuccess(true);

            if (!response.isSuccessful()) {
                result.setSuccess(false);
                Map<String, String> resultMap = mapper.readValue(resultStr, new TypeReference<Map<String, String>>() {
                });
                String code = resultMap.get("code");
                String message = resultMap.get("message");

                result.setMessage(NotionErrorCode.getDescription(code) + "：" + message);

            }

            return result;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private Request buildRequest(HttpMethod method, String fullUrl, Object requestBody) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(fullUrl)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Notion-Version", NOTION_VERSION);

        switch (method) {
            case GET:
                requestBuilder.get();
        }

        return requestBuilder.build();
    }
}
