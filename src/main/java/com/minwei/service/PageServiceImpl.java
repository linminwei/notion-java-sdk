package com.minwei.service;

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
import notion.api.v1.model.pages.PagePropertyItem;
import org.springframework.stereotype.Service;

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
        String databaseId = page.getParent() != null ? page.getParent().getPageId() : null;
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

        // 获取Notion客户端
        NotionClient client = NotionUtil.getClient(token);

        PagePropertyItem pagePropertyItem = client.retrievePagePropertyItem(pageId, propertyId, startCursor, 20);

        List<PagePropertyItem> results = pagePropertyItem.getResults();
        // 提取关联关系 id
        List<String> relationIds = new ArrayList<>();

        if (results != null) {
            relationIds = results.stream()
                    .flatMap(result -> result.getRelation().stream().map(PageProperty.PageReference::getId))
                    .collect(Collectors.toList());
        }
        // 提取游标
        String nextCursor = pagePropertyItem.getNextCursor();

        return QueryRelationVo.builder()
                .relationIds(relationIds)
                .nextCursor(nextCursor).build();
    }
}
