package com.minwei.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minwei.dto.NotionPropertyConfigDTO;
import com.minwei.utils.DateUtil;
import com.minwei.utils.NotionUtil;
import com.minwei.vo.PageVo;
import com.minwei.vo.QueryRelationVo;
import notion.api.v1.NotionClient;
import notion.api.v1.model.common.File;
import notion.api.v1.model.common.PropertyType;
import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageParent;
import notion.api.v1.model.pages.PageProperty;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lmw
 */
@Service
public class PageServiceImpl implements PageService {

    @Override
    public <T> String createPage(T object,String token,String databaseId) {

        // 获取Notion业务实体配置
        List<NotionPropertyConfigDTO> notionPropertyConfig = NotionUtil.getNotionPropertyConfig(object);
        // 获取Notion客户端
        NotionClient client = NotionUtil.getClient(token);
        // 构建属性
        Map<String, PageProperty> pagePropertyMap = NotionUtil.buildProperties(notionPropertyConfig);
        // 获取icon配置
        File iconFile = NotionUtil.getFileFromConfig(notionPropertyConfig, NotionPropertyConfigDTO::getIsIcon);
        // 获取cover配置
        File coverFile = NotionUtil.getFileFromConfig(notionPropertyConfig, NotionPropertyConfigDTO::getIsCover);
        return client.createPage(PageParent.database(databaseId), pagePropertyMap, null, iconFile, coverFile).getId();
    }

    @Override
    public <T> List<String> batchCreatePage(List<T> objects,String token,String databaseId) {
        return objects.stream().map(object-> createPage(object,token,databaseId)).collect(Collectors.toList());
    }

    @Override
    public PageVo selectById(String id, String token) {
        // 获取Notion客户端
        NotionClient client = NotionUtil.getClient(token);

        Page page = client.retrievePage(id, null);

        // 页面ID
        String pageId = page.getId();
        // 数据库id
        String databaseId = page.getParent() != null ? page.getParent().getDatabaseId() : null;
        // icon文件
        File icon = (File) page.getIcon();
        String iconUrl = null;
        if (icon != null) {
            if (icon.getFile() != null) {
                iconUrl = icon.getFile().getUrl();
            }
            if (icon.getExternal() != null) {
                iconUrl = icon.getExternal().getUrl();
            }
        }

        // cover文件
        File cover = (File) page.getCover();
        String coverUrl = null;
        if (cover != null) {
            if (cover.getFile() != null) {
                coverUrl = cover.getFile().getUrl();
            }
            if (cover.getExternal() != null) {
                coverUrl = cover.getExternal().getUrl();
            }
        }
        // 创建时间
        String createdTime = page.getCreatedTime();
        Date createdTimeDate = DateUtil.parseDate(createdTime);
        // 更新时间
        String updateTime = page.getLastEditedTime();
        Date updateTimeDate = DateUtil.parseDate(updateTime);
        // 属性列表
        List<PageVo.Property> properties = page.getProperties().entrySet().stream()
                .map(entry -> {
                    String propertyName = entry.getKey();
                    PageProperty pageProperty = entry.getValue();
                    // 获取属性类型
                    PropertyType type = pageProperty.getType();

                    PageVo.Property property = new PageVo.Property();
                    property.setName(propertyName);
                    property.setType(type);


                    if (PropertyType.Relation.equals(type)) {
                        // 由于Notion限制,无法直接获取完整引用列表,需调用其余接口查询
                        // 获取属性ID
                        String propertyId = pageProperty.getId();
                        // 检索关联属性完整引用
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
                        property.setValue(relationIds);

                        return property;
                    }

                    Object value = NotionUtil.getValueByType(pageProperty);
                    property.setValue(value);
                    return property;
                }).collect(Collectors.toList());
        return PageVo.builder()
                .id(pageId)
                .databaseId(databaseId)
                .icon(iconUrl)
                .cover(coverUrl)
                .properties(properties)
                .createTime(createdTimeDate)
                .updateTime(updateTimeDate).build();
    }

    private QueryRelationVo execute(String pageId, String propertyId, String startCursor, String token) {

        String url = "https://api.notion.com/v1/pages/" + pageId + "/properties/" + propertyId;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Notion-Version", "2022-06-28")
                .build();

        OkHttpClient client = new OkHttpClient();

        String json;
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            json = response.body().string();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        QueryRelationVo queryRelationVo = new QueryRelationVo();

        // 提取 next_cursor
        JsonNode nextCursorNode = rootNode.get("next_cursor");
        if (nextCursorNode != null && !nextCursorNode.isNull()) {
            queryRelationVo.setNextCursor(nextCursorNode.asText());
        }

        // 提取 relationIds
        List<String> relationIds = new ArrayList<>();
        JsonNode resultsNode = rootNode.get("results");
        if (resultsNode != null && resultsNode.isArray()) {
            for (JsonNode resultNode : resultsNode) {
                JsonNode relationNode = resultNode.get("relation");
                if (relationNode != null) {
                    JsonNode idNode = relationNode.get("id");
                    if (idNode != null && !idNode.isNull()) {
                        relationIds.add(idNode.asText());
                    }
                }
            }
        }
        queryRelationVo.setRelationIds(relationIds);

        return queryRelationVo;
    }
}
