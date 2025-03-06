package com.minwei.reposotpry.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.minwei.reposotpry.PageRepository;
import com.minwei.vo.QueryRelationVo;
import okhttp3.*;
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
            ResponseBody body = response.body();
            String bodyStr = body.string();
            JSONObject responseBody = JSONObject.parseObject(bodyStr);
            JSONArray resultArray = JSONArray.from(responseBody.get("results"));
            // 提取关联关系id
            List<String> relationIds = resultArray.stream().map(result -> {
                String resultStr = result.toString();
                Object relationObject = JSONObject.parseObject(resultStr).get("relation");
                return JSONObject.parseObject(relationObject.toString()).get("id").toString();
            }).collect(Collectors.toList());
            // 提取游标
            startCursor = responseBody.get("next_cursor") != null ? responseBody.get("next_cursor").toString() : null;

            return QueryRelationVo.builder()
                    .relationIds(relationIds)
                    .nextCursor(startCursor).build();
        } catch (IOException e) {
            throw new RuntimeException("获取关联属性完整引用异常" + e.getMessage(), e);
        }
    }

}
