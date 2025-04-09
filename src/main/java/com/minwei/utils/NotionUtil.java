package com.minwei.utils;

import com.minwei.anno.NotionProperty;
import com.minwei.constants.FilterType;
import com.minwei.dto.NotionPropertyConfigDTO;
import com.minwei.enums.DateFormatEnum;
import com.minwei.service.PageService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import notion.api.v1.NotionClient;
import notion.api.v1.model.common.*;
import notion.api.v1.model.databases.DatabaseProperty;
import notion.api.v1.model.databases.query.filter.PropertyFilter;
import notion.api.v1.model.databases.query.filter.condition.*;
import notion.api.v1.model.pages.PageProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author lmw
 */

@Slf4j
@Component
public class NotionUtil {

    @Getter
    private static PageService pageService;
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        pageService = applicationContext.getBean(PageService.class);
    }

    /**
     * 实例化Notion客户端
     *
     * @param token token
     * @return NotionClient
     */
    public static NotionClient getClient(String token) {
        try (NotionClient client = new NotionClient(token)) {
            return client;
        } catch (Exception e) {
            throw new RuntimeException("实例化Notion客户端异常", e);
        }
    }


    public static <T> List<NotionPropertyConfigDTO> getNotionPropertyConfig(Class<T> clazz) {
        // 通过类对象获取到Object实例
        T object;
        try {
            object = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("通过类对象获取Object实例异常:" + e.getMessage(), e);
        }
        return getNotionPropertyConfigDTO(clazz, object);
    }

    /**
     * 获取Notion业务实体相关配置
     *
     * @param object object
     * @param <T>    泛型
     * @return NotionEntityConfigDTO
     */
    public static <T> List<NotionPropertyConfigDTO> getNotionPropertyConfig(T object) {
        // 获取Object类对象
        Class<?> clazz = object.getClass();
        return getNotionPropertyConfigDTO(clazz, object);
    }

    private static <T> List<NotionPropertyConfigDTO> getNotionPropertyConfigDTO(Class<?> clazz, T object) {

        // 获取对象的所有字段
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields).map(field -> {
            // 暴力反射
            field.setAccessible(true);
            // 获取配置在字段上的NotionProperty注解
            NotionProperty notionProperty = field.getAnnotation(NotionProperty.class);
            // 属性名
            String name = notionProperty.name();
            // 属性类型
            PropertyType type = notionProperty.type();
            // 是否指定为icon
            boolean icon = notionProperty.isIcon();
            // 是否指定为cover
            boolean cover = notionProperty.isCover();
            // 属性值
            Object value;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                log.error("属性名:{},获取属性值失败,{}", name, e.getMessage(), e);
                throw new RuntimeException(e);
            }
            return NotionPropertyConfigDTO.builder()
                    .name(name)
                    .type(type)
                    .value(value)
                    .isIcon(icon)
                    .isCover(cover).build();
        }).collect(Collectors.toList());
    }

    /**
     * 构建Notion属性
     *
     * @param properties properties
     * @return Map<String, PageProperty>
     */
    public static Map<String, PageProperty> buildProperties(List<NotionPropertyConfigDTO> properties) {

        Map<String, PageProperty> pagePropertyMap = new HashMap<>();

        properties.forEach(property -> {
            // 属性名
            String name = property.getName();
            // 属性类型
            PropertyType type = property.getType();
            // 属性值
            Object value = property.getValue();

            if (value  == null || "null".equals(value)) {
                return;
            }

            // 构建属性
            PageProperty pageProperty = new PageProperty();

            switch (type) {
                case Title:
                    PageProperty.RichText title = new PageProperty.RichText();
                    title.setText(new PageProperty.RichText.Text((String) value));
                    pageProperty.setTitle(Collections.singletonList(title));
                    break;
                case RichText:
                    PageProperty.RichText richText = new PageProperty.RichText();
                    richText.setText(new PageProperty.RichText.Text((String) value));
                    pageProperty.setRichText(Collections.singletonList(richText));
                    break;
                case Number:
                    pageProperty.setNumber(ConvertUtil.asNumber(value));
                    break;
                case Select:
                    DatabaseProperty.Select.Option option = new DatabaseProperty.Select.Option(null, (String) value, OptionColor.Default, null);
                    pageProperty.setSelect(option);
                    break;
                case MultiSelect:
                    List<String> multiSelect = ConvertUtil.asList(value, String.class);
                    List<DatabaseProperty.MultiSelect.Option> options = multiSelect.stream().map(select -> new DatabaseProperty.MultiSelect.Option(null, select, OptionColor.Default, null)).collect(Collectors.toList());
                    pageProperty.setMultiSelect(options);
                    break;
                case Date:
                    Date date = (Date) value;
                    String formatDate = DateUtil.formatDate(date, DateFormatEnum.YYYY_MM_DD_LINE.getValue());
                    pageProperty.setDate(new PageProperty.Date(formatDate));
                    break;
                case Files:
                    Map<String, String> fileMap = ConvertUtil.asMap(value, String.class);
                    List<PageProperty.File> files = fileMap.entrySet().stream().map(entry -> {
                        String fileName = entry.getKey();
                        String fileUrl = entry.getValue();
                        return new PageProperty.File(fileName, FileType.External, null, new ExternalFileDetails(fileUrl));
                    }).collect(Collectors.toList());
                    pageProperty.setFiles(files);
                    break;
                case Checkbox:
                    Boolean valueBoolean = (Boolean) value;
                    pageProperty.setCheckbox(valueBoolean);
                    break;
                case Url:
                    pageProperty.setUrl((String) value);
                    break;
                case Email:
                    pageProperty.setEmail((String) value);
                    break;
                case PhoneNumber:
                    pageProperty.setPhoneNumber((String) value);
                    break;
                case Relation:
                    List<String> relations = ConvertUtil.asList(value, String.class);
                    List<PageProperty.PageReference> pageReferences = relations.stream()
                            .map(PageProperty.PageReference::new)
                            .collect(Collectors.toList());
                    pageProperty.setRelation(pageReferences);
                    break;
            }
            pagePropertyMap.put(name, pageProperty);
        });
        return pagePropertyMap;
    }


    /**
     * 获取icon或cover配置
     *
     * @param properties properties
     * @param predicate  predicate
     * @return File
     */
    public static File getFileFromConfig(List<NotionPropertyConfigDTO> properties, Predicate<NotionPropertyConfigDTO> predicate) {
        List<NotionPropertyConfigDTO> filteredConfigs = properties.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        if (!filteredConfigs.isEmpty()) {
            NotionPropertyConfigDTO propertyConfig = filteredConfigs.get(0);
            Map<String, String> fileMap = ConvertUtil.asMap(propertyConfig.getValue(), String.class);
            String url = fileMap.entrySet().stream()
                    .findFirst()
                    .map(Map.Entry::getValue)
                    .orElse(null);
            return new File(FileType.External, new ExternalFileDetails(url));
        }
        return null;
    }


    /**
     * 根据属性类型获取属性值
     *
     * @param pageProperty pageProperty
     * @return Object
     */
    public static Object getValueByType(PageProperty pageProperty) {
        PropertyType type = pageProperty.getType();
        if (type == null) {
            return null;
        }
        switch (type) {
            case Title:
                List<PageProperty.RichText> title = pageProperty.getTitle();
                return title != null && !title.isEmpty() ? title.get(0).getPlainText() : null;
            case RichText:
                List<PageProperty.RichText> richText = pageProperty.getRichText();
                return richText != null && !richText.isEmpty() ? richText.get(0).getPlainText() : null;
            case Select:
                DatabaseProperty.Select.Option select = pageProperty.getSelect();
                return select != null ? select.getName() : null;
            case MultiSelect:
                List<DatabaseProperty.MultiSelect.Option> multiSelects = pageProperty.getMultiSelect();
                if (multiSelects == null) {
                    return Collections.emptyList();
                }
                return multiSelects.stream()
                        .map(DatabaseProperty.MultiSelect.Option::getName)
                        .collect(Collectors.toList());
            case Number:
                Number number = pageProperty.getNumber();
                if (number == null) {
                    return null;
                }
                if (NumberUtil.checkType(number, Integer.class)) {
                    return number.intValue();
                }
                if (NumberUtil.checkType(number, BigDecimal.class)) {
                    return number.doubleValue();
                }
                return null;
            case Date:
                PageProperty.Date date = pageProperty.getDate();
                if (date == null) {
                    return null;
                }
                String dateTime = date.getStart();
                return DateUtil.parseDate(dateTime);
            case CreatedTime:
                String createdTime = pageProperty.getCreatedTime();
                if (StringUtils.isNotBlank(createdTime)) {
                    Instant instant = Instant.parse(createdTime);
                    return Date.from(instant);
                }
            case LastEditedTime:
                String lastEditedTime = pageProperty.getLastEditedTime();
                if (StringUtils.isNotBlank(lastEditedTime)) {
                    Instant instant = Instant.parse(lastEditedTime);
                    return Date.from(instant);
                }
            case Files:
                HashMap<String, String> filesMap = new HashMap<>();
                List<PageProperty.File> files = pageProperty.getFiles();
                if (files == null) {
                    return filesMap;
                }
                files.forEach(file -> {
                    String fileName = file.getName();
                    String fileUrl = file.getFile() != null ? file.getFile().getUrl() : null;
                    filesMap.put(fileName, fileUrl);
                });
                return filesMap;
            case Relation:
                List<PageProperty.PageReference> relations = pageProperty.getRelation();
                if (relations == null || relations.isEmpty()) {
                    return null;
                }
                return relations.stream().map(relation -> StringUtils.isNotBlank(relation.getId()) ? relation.getId() : null);
            case Url:
                return pageProperty.getUrl();
            case Checkbox:
                return pageProperty.getCheckbox();
            case PhoneNumber:
                return pageProperty.getPhoneNumber();
        }
        return null;
    }

    public static PropertyFilter buildFilterByPropertyType(String propertyName, PropertyType type, String filterType, Object filterValue) {
        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setProperty(propertyName);
        switch (type) {
            case Title:
                propertyFilter.setTitle(getTextFilter(filterType, (String) filterValue));
                return propertyFilter;
            case RichText:
                propertyFilter.setRichText(getTextFilter(filterType, (String) filterValue));
                return propertyFilter;
            case Select:
                propertyFilter.setSelect(getSelectFilter(filterType, (String) filterValue));
                return propertyFilter;
            case MultiSelect:
                propertyFilter.setMultiSelect(getMultiSelectFilter(filterType, (String) filterValue));
            case Number:
                propertyFilter.setNumber(getNumberFilter(filterType, (Integer) filterValue));
            case Date:
                propertyFilter.setDate(getDateFilter(filterType, DateUtil.formatDate((Date) filterValue, DateFormatEnum.YYYY_MM_DD_LINE.getValue())));
            case Files:
                propertyFilter.setFile(getFileFilter(filterType));
            case Checkbox:
                propertyFilter.setCheckbox(getCheckboxFilter(filterType));
            case Relation:
                propertyFilter.setRelation(getRelationFiler(filterType, (String) filterValue));
        }
        return null;
    }


    private static RelationFilter getRelationFiler(String filterType, String relationId) {
        if (FilterType.CONTAINS.equals(filterType)) {
            return new RelationFilter(relationId);
        }
        if (FilterType.NOT_CONTAINS.equals(filterType)) {
            return new RelationFilter(null, relationId);
        }
        if (FilterType.IS_EMPTY.equals(filterType)) {
            return new RelationFilter(null, null, true);
        }
        if (FilterType.IS_NOT_EMPTY.equals(filterType)) {
            return new RelationFilter(null, null, null, true);
        }
        return null;
    }

    private static CheckboxFilter getCheckboxFilter(String filterType) {
        if (FilterType.EQUAL.equals(filterType)) {
            return new CheckboxFilter(true);
        }
        if (FilterType.NOT_EQUAL.equals(filterType)) {
            return new CheckboxFilter(null, true);
        }
        return null;
    }

    private static FilesFilter getFileFilter(String filterType) {
        if (FilterType.IS_EMPTY.equals(filterType)) {
            return new FilesFilter(true);
        }
        if (FilterType.IS_NOT_EMPTY.equals(filterType)) {
            return new FilesFilter(null, true);
        }
        return null;
    }

    private static DateFilter getDateFilter(String filterType, String filterValue) {
        if (FilterType.EQUAL.equals(filterType)) {
            return new DateFilter(filterValue);
        }
        if (FilterType.BEFORE.equals(filterType)) {
            return new DateFilter(null, filterValue);
        }
        if (FilterType.AFTER.equals(filterType)) {
            return new DateFilter(null, null, filterValue);
        }
        if (FilterType.ON_OR_BEFORE.equals(filterType)) {
            return new DateFilter(null, null, null, filterValue);
        }
        if (FilterType.ON_OR_AFTER.equals(filterType)) {
            return new DateFilter(null, null, null, null, filterValue);
        }
        if (FilterType.PAST_WEEK.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, new DateFilter.DateCondition());
        }
        if (FilterType.PAST_MONTH.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, null, new DateFilter.DateCondition());
        }
        if (FilterType.PAST_YEAR.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, null, null, new DateFilter.DateCondition());
        }
        if (FilterType.NEXT_WEEK.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, null, null, null, new DateFilter.DateCondition());
        }
        if (FilterType.NEXT_MONTH.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, null, null, null, null,
                    new DateFilter.DateCondition());
        }
        if (FilterType.NEXT_YEAR.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, null, null, null, null, null,
                    new DateFilter.DateCondition());
        }
        if (FilterType.IS_EMPTY.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, null, null, null, null, null,
                    null, true);
        }
        if (FilterType.IS_NOT_EMPTY.equals(filterType)) {
            return new DateFilter(null, null, null, null, null, null, null, null, null, null,
                    null, null, true);
        }
        return null;
    }

    private static NumberFilter getNumberFilter(String filterType, Integer filterValue) {
        if (FilterType.EQUAL.equals(filterType)) {
            return new NumberFilter(filterValue);
        }
        if (FilterType.NOT_EQUAL.equals(filterType)) {
            return new NumberFilter(null, filterValue);
        }
        if (FilterType.GREATER_THAN.equals(filterType)) {
            return new NumberFilter(null, null, filterValue);
        }
        if (FilterType.LESS_THAN.equals(filterType)) {
            return new NumberFilter(null, null, null, filterValue);
        }
        if (FilterType.GREATER_THAN_OR_EQUAL_TO.equals(filterType)) {
            return new NumberFilter(null, null, null, null, filterValue);
        }
        if (FilterType.LESS_THAN_OR_EQUAL_TO.equals(filterType)) {
            return new NumberFilter(null, null, null, null, null, filterValue);
        }
        if (FilterType.IS_EMPTY.equals(filterType)) {
            return new NumberFilter(null, null, null, null, null, null, true);
        }
        if (FilterType.IS_NOT_EMPTY.equals(filterType)) {
            return new NumberFilter(null, null, null, null, null, null, null, true);
        }
        return null;
    }

    private static MultiSelectFilter getMultiSelectFilter(String filterType, String filterValue) {
        if (FilterType.CONTAINS.equals(filterType)) {
            return new MultiSelectFilter(filterValue);
        }
        if (FilterType.NOT_EQUAL.equals(filterType)) {
            return new MultiSelectFilter(null, filterValue);
        }
        if (FilterType.IS_EMPTY.equals(filterType)) {
            return new MultiSelectFilter(null, null, true);
        }
        if (FilterType.IS_NOT_EMPTY.equals(filterType)) {
            return new MultiSelectFilter(null, null, null, true);
        }
        return null;
    }

    private static SelectFilter getSelectFilter(String filterType, String filterValue) {
        if (FilterType.EQUAL.equals(filterType)) {
            return new SelectFilter(filterValue);
        }
        if (FilterType.NOT_EQUAL.equals(filterType)) {
            return new SelectFilter(null, filterValue);
        }
        if (FilterType.IS_EMPTY.equals(filterType)) {
            return new SelectFilter(null, null, true, null);
        }
        if (FilterType.IS_NOT_EMPTY.equals(filterType)) {
            return new SelectFilter(null, null, null, true);
        }
        return null;
    }

    private static TextFilter getTextFilter(String filterType, String filterValue) {

        if (FilterType.EQUAL.equals(filterType)) {
            return new TextFilter(filterValue);
        }
        if (FilterType.NOT_EQUAL.equals(filterType)) {
            return new TextFilter(null, filterValue);
        }
        if (FilterType.CONTAINS.equals(filterType)) {
            return new TextFilter(null, null, filterValue);
        }
        if (FilterType.NOT_CONTAINS.equals(filterType)) {
            return new TextFilter(null, null, null, filterValue);
        }
        if (FilterType.STARTS_WITH.equals(filterType)) {
            return new TextFilter(null, null, null, null, filterValue);
        }
        if (FilterType.ENDS_WITH.equals(filterType)) {
            return new TextFilter(null, null, null, null, null, filterValue);
        }
        if (FilterType.IS_EMPTY.equals(filterType)) {
            return new TextFilter(null, null, null, null, null, null, true);
        }
        if (FilterType.IS_NOT_EMPTY.equals(filterType)) {
            return new TextFilter(null, null, null, null, null, null, null, true);
        }
        return null;
    }
}
