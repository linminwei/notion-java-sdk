package com.minwei.notion;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minwei.notion.api.request.BaseRequest;
import com.minwei.notion.api.response.BaseResponse;
import com.minwei.notion.exception.NotionException;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Notion客户端
 *
 * @author lmw 2025/06/18
 */
public class NotionClient {

    @Value("${notion.version}")
    private String version = "2022-06-28";
    @Value("${notion.url}")
    private String baseUrl = "https://api.notion.com/v1";

    private final OkHttpClient client;

    private final String token;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public NotionClient(String token) {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS).build();
        this.token = token;
    }

    public <T extends BaseResponse> T execute(BaseRequest<T> request){
        try {
            // 检索是否有路径参数
            Map<String, String> queryParams = request.getQueryParams();
            if (!queryParams.isEmpty()) {
                String endpoint = request.getEndpoint();
                // 存在路径参数,替换路径参数
                Pattern pattern = Pattern.compile("\\{([^}]+)\\}");
                Matcher matcher = pattern.matcher(endpoint);
                StringBuffer sb = new StringBuffer();
                while (matcher.find()){
                    String paramName = matcher.group(1);
                    String replacement = queryParams.getOrDefault(paramName, "");
                    matcher.appendReplacement(sb,Matcher.quoteReplacement(replacement));
                }
                baseUrl = baseUrl + sb;
            }

            Request.Builder requestBuilder = new Request.Builder().url(baseUrl)
                    .header("Authorization", "Bearer " + token)
                    .header("Notion-Version", version)
                    .header("Content-Type", "application/json");


            switch (request.getMethod()){
                case GET:
                    requestBuilder.get();
                    break;
                case POST:
                    if (request.getRequestBody() != null) {
                        RequestBody requestBody = buildRequestBody(request.getRequestBody());
                        requestBuilder.post(requestBody);
                    }
                    break;
                case PATCH:
                    if (request.getRequestBody() != null) {
                        RequestBody requestBody = buildRequestBody(request.getRequestBody());
                        requestBuilder.patch(requestBody);
                    }
                    break;
                case DELETE:
                    requestBuilder.delete();
            }
            // 执行
            try (Response response = client.newCall(requestBuilder.build()).execute()) {
                if (!response.isSuccessful()){
                    throw new NotionException("调用Notion接口失败:" + response);
                }
                String responseBody = response.body().string();
                return OBJECT_MAPPER.readValue(responseBody, request.getResponseClass());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private RequestBody buildRequestBody(Object requestBody) throws JsonProcessingException {
        String body = OBJECT_MAPPER.writeValueAsString(requestBody);
        return RequestBody.create(body,MediaType.parse("application/json; charset=utf-8"));
    }



}
