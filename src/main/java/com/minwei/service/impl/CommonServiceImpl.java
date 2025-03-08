package com.minwei.service.impl;

import com.minwei.anno.NotionProperty;
import com.minwei.config.NotionConfig;
import com.minwei.service.CommonService;
import com.minwei.vo.NotionConfigVo;
import com.minwei.vo.NotionPropertyConfigVo;
import lombok.extern.slf4j.Slf4j;
import notion.api.v1.NotionClient;
import notion.api.v1.model.common.PropertyType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Notion通用服务实现类
 * @author lmw
 */
@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

    @Resource
    private NotionConfig notionConfig;


    @Override
    public NotionClient getNotionClient(String token) {
        try(NotionClient client = new NotionClient(token)) {
            return client;
        } catch (Exception e) {
            throw new RuntimeException("实例化Notion客户端异常",e);
        }
    }

    @Override
    public NotionConfigVo getNotionConfig(Object object) {
        // 获取实体全类名
        String classFullName = object.getClass().getName();
        String token = notionConfig.token(classFullName);
        String databaseId = notionConfig.databaseId(classFullName);

        NotionConfigVo notionConfigVo = new NotionConfigVo();
        notionConfigVo.setToken(token);
        notionConfigVo.setDatabaseId(databaseId);
        return notionConfigVo;
    }

    @Override
    public <T> List<NotionPropertyConfigVo> getNotionPropertyConfig(T object) {
        // 获取类对象
        Class<?> clazz = object.getClass();
        // 获取类对象的所有字段
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields).map(field -> {
            // 暴力反射
            field.setAccessible(true);
            // 获取配置在Notion业务实体字段上的NotionProperty注解
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

            return NotionPropertyConfigVo.builder()
                    .propertyName(name)
                    .propertyType(type)
                    .isIcon(icon)
                    .isCover(cover)
                    .value(value).build();
        }).collect(Collectors.toList());
    }


}
