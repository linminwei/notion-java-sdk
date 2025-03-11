package com.minwei.client;

import com.minwei.exception.NotionException;
import com.minwei.http.response.NotionErrorResponse;
import com.minwei.http.response.NotionResponse;
import com.minwei.utils.JsonUtil;
import okhttp3.*;

import java.io.IOException;

/**
 * Notion客户端
 *
 * @author lmw
 */
public class NotionClient {

    private static final String NOTION_API_BASE_URL = "https://api.notion.com/v1";

    private static final String NOTION_API_VERSION = "2022-06-28";

    private final OkHttpClient client = new OkHttpClient();

    private final String token;

    public NotionClient(String token) {
        this.token = token;
    }

    /**
     * 发送 GET 请求
     *
     * @param endpoint     API 端点
     * @param responseType 响应类型
     * @param <T>          响应数据类型
     * @return NotionResponse<T>
     */
    public <T> NotionResponse<T> get(String endpoint, Class<T> responseType) {
        Request request = new Request.Builder()
                .url(NOTION_API_BASE_URL + endpoint)
                .get()
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Notion-Version", NOTION_API_VERSION).build();

        return executeRequest(request, responseType);
    }

    /**
     * 发送 POST 请求
     *
     * @param endpoint     API 端点
     * @param jsonBody     请求体 JSON 字符串
     * @param responseType 响应类型
     * @param <T>          响应数据类型
     * @return NotionResponse<T>
     */
    public <T> NotionResponse<T> post(String endpoint, String jsonBody, Class<T> responseType) {
        RequestBody body = RequestBody.create(jsonBody, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(NOTION_API_BASE_URL + endpoint)
                .post(body)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Notion-Version", NOTION_API_VERSION)
                .build();
        return executeRequest(request, responseType);
    }

    /**
     * 发送 PATCH 请求
     *
     * @param endpoint     API 端点
     * @param jsonBody     请求体 JSON 字符串
     * @param responseType 响应类型
     * @param <T>          响应数据类型
     * @return NotionResponse<T>
     */
    public <T> NotionResponse<T> patch(String endpoint, String jsonBody, Class<T> responseType) {
        RequestBody body = RequestBody.create(jsonBody, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(NOTION_API_BASE_URL + endpoint)
                .patch(body)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Notion-Version", NOTION_API_VERSION)
                .build();
        return executeRequest(request, responseType);
    }

    /**
     * 发送 DELETE 请求
     *
     * @param endpoint     API 端点
     * @param responseType 响应类型
     * @param <T>          响应数据类型
     * @return NotionResponse<T>
     */
    public <T> NotionResponse<T> delete(String endpoint, Class<T> responseType) {
        Request request = new Request.Builder()
                .url(NOTION_API_BASE_URL + endpoint)
                .delete()
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Notion-Version", NOTION_API_VERSION)
                .build();
        return executeRequest(request, responseType);
    }

    /**
     * 执行请求并处理响应
     *
     * @param request      请求对象
     * @param responseType 响应类型
     * @param <T>          响应数据类型
     * @return NotionResponse<T>
     */
    private <T> NotionResponse<T> executeRequest(Request request, Class<T> responseType) {
        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                throw new NotionException("notion返回空数据：" + response);
            }

            if (!response.isSuccessful()) {
                String string = response.body().string();
                NotionErrorResponse errorResponse = JsonUtil.fromJson(string, NotionErrorResponse.class);

                NotionResponse<T> objectNotionResponse = new NotionResponse<>();
                objectNotionResponse.setNotionErrorResponse(errorResponse);
                return objectNotionResponse;
            }
            String responseBody = response.body().string();


            return JsonUtil.fromJsonByParametricType(responseBody, NotionResponse.class, responseType);
        } catch (IOException e) {
            throw new NotionException("执行Notion请求异常: ", e);
        }
    }

}
