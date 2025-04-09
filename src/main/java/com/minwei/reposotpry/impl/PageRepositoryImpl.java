package com.minwei.reposotpry.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minwei.reposotpry.PageRepository;
import com.minwei.vo.QueryRelationVo;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lmw
 */
@Repository
public class PageRepositoryImpl implements PageRepository {


    @Override
    public List<String> getRelationIds(String pageId, String propertyId, String token) {

        List<String> relationIds = new ArrayList<>();

        // 初始化游标
        String startCursor = null;

        while (true) {
            QueryRelationVo relationVo = execute(pageId, propertyId, startCursor, token);
            relationIds.addAll(relationVo.getRelationIds());
            if (relationVo.getNextCursor() != null) {
                // 若游标不为空,则表示还有下一页
                startCursor = relationVo.getNextCursor();
            } else {
                break;
            }
        }
        return relationIds;
    }

    private QueryRelationVo execute(String pageId, String propertyId, String startCursor, String token) {

        OkHttpClient client = new OkHttpClient();

        // 构建请求URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.notion.com/v1/pages/" + pageId + "/properties/" + propertyId).newBuilder();
        if (startCursor != null) {
            urlBuilder.addQueryParameter("start_cursor", startCursor);
        }
        urlBuilder.addQueryParameter("page_size", String.valueOf(100));
        String url = urlBuilder.build().toString();

        // 创建请求
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + token)
                .header("Notion-Version", "2022-06-28")
                .get()
                .build();
        // 发送请求并获取响应
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("获取关联属性完整引用失败" + response);
            }

            ObjectMapper objectMapper = new ObjectMapper();

            String bodyStr = response.body().string();

            JsonNode responseBody = objectMapper.readTree(bodyStr);

            JsonNode resultArray = responseBody.get("results");

            // 提取关联关系 id
            List<String> relationIds = new ArrayList<>();
            if (resultArray != null && resultArray.isArray()) {
                relationIds = resultArray.findValues("relation")
                        .stream()
                        .filter(relation -> relation.has("id"))
                        .map(relation -> relation.get("id").asText())
                        .collect(Collectors.toList());
            }

            // 提取游标
            JsonNode nextCursorNode = responseBody.get("next_cursor");
            if (nextCursorNode != null &&!nextCursorNode.isNull()) {
                startCursor = nextCursorNode.asText();
            }

            return QueryRelationVo.builder()
                    .relationIds(relationIds)
                    .nextCursor(startCursor)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("获取关联属性完整引用异常" + e.getMessage(), e);
        }
    }

}
