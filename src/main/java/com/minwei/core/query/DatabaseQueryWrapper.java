package com.minwei.core.query;

import com.minwei.anno.NotionProperty;
import com.minwei.constans.FilterTypeConstant;
import com.minwei.dto.NotionConfigDTO;
import com.minwei.function.SFunction;
import com.minwei.service.PageService;
import com.minwei.utils.NotionUtil;
import com.minwei.utils.ObjectUtil;
import com.minwei.vo.PageVo;
import notion.api.v1.NotionClient;
import notion.api.v1.model.common.PropertyType;
import notion.api.v1.model.databases.QueryResults;
import notion.api.v1.model.databases.query.filter.CompoundFilter;
import notion.api.v1.model.databases.query.filter.PropertyFilter;
import notion.api.v1.model.databases.query.sort.QuerySort;
import notion.api.v1.model.databases.query.sort.QuerySortDirection;
import notion.api.v1.model.databases.query.sort.QuerySortTimestamp;
import notion.api.v1.model.pages.Page;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lmw
 */
public class DatabaseQueryWrapper<T> {

    private final Class<T> clazz;
    private final CompoundFilter compoundFilter = new CompoundFilter();
    private final List<PropertyFilter> andFilter = new ArrayList<>();
    private final List<PropertyFilter> orFilter = new ArrayList<>();
    private final List<QuerySort> querySorts = new ArrayList<>();

    public DatabaseQueryWrapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public DatabaseQueryWrapper<T> andEq(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.EQUAL);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orEq(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.EQUAL);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andNotEq(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NOT_EQUAL);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orNotEq(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NOT_EQUAL);
        orFilter.add(propertyFilter);
        return this;
    }


    public DatabaseQueryWrapper<T> andContains(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.CONTAINS);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orContains(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.CONTAINS);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andNotContains(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NOT_CONTAINS);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orNotContains(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NOT_CONTAINS);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andStartsWith(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.STARTS_WITH);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orStartsWith(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.STARTS_WITH);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andEndsWith(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.ENDS_WITH);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orEndsWith(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.ENDS_WITH);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andIsEmpty(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.IS_EMPTY);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orIsEmpty(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.IS_EMPTY);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andIsNotEmpty(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.IS_NOT_EMPTY);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orIsNotEmpty(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.IS_NOT_EMPTY);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andGreaterThan(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.GREATER_THAN);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orGreaterThan(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.GREATER_THAN);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andLessThan(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.LESS_THAN);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orLessThan(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.LESS_THAN);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andGreaterThanOrEqualTo(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.GREATER_THAN_OR_EQUAL_TO);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orGreaterThanOrEqualTo(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.GREATER_THAN_OR_EQUAL_TO);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andLessThanOrEqualTo(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.LESS_THAN_OR_EQUAL_TO);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orLessThanOrEqualTo(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.LESS_THAN_OR_EQUAL_TO);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andBefore(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.BEFORE);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orBefore(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.BEFORE);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andAfter(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.AFTER);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orAfter(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.AFTER);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andOnOrBefore(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.ON_OR_BEFORE);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orOnOrBefore(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.ON_OR_BEFORE);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andOnOrAfter(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.ON_OR_AFTER);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orOnOrAfter(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.ON_OR_AFTER);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andPastWeek(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.PAST_WEEK);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orPastWeek(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.PAST_WEEK);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andPastMonth(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.PAST_MONTH);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orPastMonth(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.PAST_MONTH);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andPastYear(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.PAST_YEAR);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orPastYear(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.PAST_YEAR);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andNextWeek(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NEXT_WEEK);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orNextMonth(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NEXT_MONTH);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> andNextYear(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NEXT_YEAR);
        andFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> orNextYear(SFunction<T, ?> queryField, Object value) {
        PropertyFilter propertyFilter = buildFilterCommon(queryField, value, FilterTypeConstant.NEXT_YEAR);
        orFilter.add(propertyFilter);
        return this;
    }

    public DatabaseQueryWrapper<T> sort(SFunction<T, ?> sortField, QuerySortDirection sortType) {
        // 获取字段信息
        Field field = ObjectUtil.getField(sortField);
        // 获取该字段所配置的Notion属性信息
        NotionProperty notionProperty = field.getAnnotation(NotionProperty.class);
        String name = notionProperty.name();
        PropertyType type = notionProperty.type();
        //构建QuerySort
        QuerySort querySort = new QuerySort();
        querySort.setProperty(name);
        querySort.setDirection(sortType);
        if (PropertyType.CreatedTime.equals(type)) {
            querySort.setTimestamp(QuerySortTimestamp.CreatedTime);
        }
        if (PropertyType.LastEditedTime.equals(type)) {
            querySort.setTimestamp(QuerySortTimestamp.LastEditedTime);
        }
        querySorts.add(querySort);
        return this;
    }

    /**
     * 构建条件过滤通用方法
     *
     * @param queryField 检索字段
     * @param value      检索值
     */
    private PropertyFilter buildFilterCommon(SFunction<T, ?> queryField, Object value, String filterType) {
        // 获取字段信息
        Field field = ObjectUtil.getField(queryField);
        // 获取该字段所配置的Notion属性信息
        NotionProperty notionProperty = field.getAnnotation(NotionProperty.class);
        String name = notionProperty.name();
        PropertyType type = notionProperty.type();
        // 根据属性构建条件过滤器
        return NotionUtil.buildFilterByPropertyType(name, type, filterType, value);
    }


    public List<PageVo> query() {
        // 将构建的相关Filter设置到CompoundFilter中
        compoundFilter.setAnd(andFilter);
        compoundFilter.setOr(orFilter);
        // 获取Notion业务实体配置
        NotionConfigDTO notionConfig = NotionUtil.getNotionConfig(clazz);
        // 获取Notion客户端
        NotionClient client = NotionUtil.getClient(notionConfig.getToken());
        // 初始化游标
        String startCursor = null;
        // 初始化检索页对象
        List<PageVo> pageVoList = new ArrayList<>();

        while (true) {

            QueryResults queryResults = client.queryDatabase(notionConfig.getDatabaseId(), compoundFilter, querySorts, startCursor, 100);

            List<PageVo> pageVos = queryResults.getResults().stream().map(page -> {
                // 获取页面id
                String id = page.getId();
                // 根据id检索页面
                PageService pageService = NotionUtil.getPageService();
                return pageService.selectById(id, notionConfig.getToken());
            }).collect(Collectors.toList());

            pageVoList.addAll(pageVos);

            if (queryResults.getHasMore()) {
                startCursor = queryResults.getNextCursor();
            } else {
                break;
            }
        }
        return pageVoList;
    }

    public List<String> queryId() {
        // 将构建的相关Filter设置到CompoundFilter中
        compoundFilter.setAnd(andFilter);
        compoundFilter.setOr(orFilter);
        // 获取Notion业务实体配置
        NotionConfigDTO notionConfig = NotionUtil.getNotionConfig(clazz);
        // 获取Notion客户端
        NotionClient client = NotionUtil.getClient(notionConfig.getToken());
        // 初始化游标
        String startCursor = null;
        // 初始化检索页对象
        List<String> pageIdList = new ArrayList<>();

        while (true) {

            QueryResults queryResults = client.queryDatabase(notionConfig.getDatabaseId(), compoundFilter, querySorts, startCursor, 100);

            // 获取页面id
            List<String> pageIds = queryResults.getResults().stream().map(Page::getId).collect(Collectors.toList());

            pageIdList.addAll(pageIds);

            if (queryResults.getHasMore()) {
                startCursor = queryResults.getNextCursor();
            } else {
                break;
            }
        }
        return pageIdList;
    }


    public List<String> queryAndSave(T object) {
        // 将构建的相关Filter设置到CompoundFilter中
        compoundFilter.setAnd(andFilter);
        compoundFilter.setOr(orFilter);
        // 获取Notion业务实体配置
        NotionConfigDTO notionConfig = NotionUtil.getNotionConfig(clazz);
        // 获取Notion客户端
        NotionClient client = NotionUtil.getClient(notionConfig.getToken());
        // 初始化游标
        String startCursor = null;
        // 初始化检索页对象
        List<String> pageIdList = new ArrayList<>();

        while (true) {

            QueryResults queryResults = client.queryDatabase(notionConfig.getDatabaseId(), compoundFilter, querySorts, startCursor, 100);

            // 获取页面id
            List<String> pageIds = queryResults.getResults().stream().map(Page::getId).collect(Collectors.toList());

            if (pageIds.isEmpty()) {
                // 数据不存在,新增
                PageService pageService = NotionUtil.getPageService();
                String pageId = pageService.createPage(object);
                pageIdList.add(pageId);
            }
            pageIdList.addAll(pageIds);

            if (queryResults.getHasMore()) {
                startCursor = queryResults.getNextCursor();
            } else {
                break;
            }
        }
        return pageIdList;
    }
}
