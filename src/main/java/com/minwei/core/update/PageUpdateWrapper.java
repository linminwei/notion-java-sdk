package com.minwei.core.update;

import com.minwei.anno.NotionProperty;
import com.minwei.dto.NotionPropertyConfigDTO;
import com.minwei.function.SFunction;
import com.minwei.utils.NotionUtil;
import com.minwei.utils.ObjectUtil;
import notion.api.v1.NotionClient;
import notion.api.v1.model.common.PropertyType;
import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageProperty;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author lmw
 */
public class PageUpdateWrapper<T> {

    private Class<T> object;
    private String pageId;
    private Map<String, PageProperty> updateFields = new HashMap<>();

    public PageUpdateWrapper(Class<T> object) {
        this.object = object;
    }

    /**
     * 设置所更新的PageId
     *
     * @param pageId 设置所更新的PageId
     * @return PageUpdateWrapper
     */
    public PageUpdateWrapper<T> pageId(String pageId) {
        this.pageId = pageId;
        return this;
    }

    /**
     * 构建更新字段属性Map
     *
     * @param updateField updateField 所更新字段
     * @param value       value 所更新字段值
     * @return
     */
    public PageUpdateWrapper<T> updateFiled(SFunction<T, ?> updateField, Object value) {
        Map<String, PageProperty> propertyMap = getPropertyMap(updateField, value);
        updateFields.putAll(propertyMap);
        return this;
    }

    /**
     * 获取配置的Notion属性名
     *
     * @param updateField updateField
     * @return Notion属性名
     */
    private Map<String, PageProperty> getPropertyMap(Function<T, ?> updateField, Object value) {
        Field field = ObjectUtil.getField(updateField);
        NotionProperty notionProperty = field.getAnnotation(NotionProperty.class);
        String name = notionProperty.name();
        PropertyType type = notionProperty.type();
        // 构建Notion属性Map
        NotionPropertyConfigDTO property = NotionPropertyConfigDTO.builder()
                .name(name)
                .type(type)
                .value(value)
                .build();
        return NotionUtil.buildProperties(Collections.singletonList(property));
    }


    public String update(String token) {

        // 获取Notion客户端
        NotionClient client = NotionUtil.getClient(token);
        Page page = client.updatePage(pageId, updateFields, null, null, null);
        return page.getId();
    }
}
