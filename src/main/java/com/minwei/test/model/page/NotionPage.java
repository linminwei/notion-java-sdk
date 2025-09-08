package com.minwei.test.model.page;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minwei.test.model.common.parent.Parent;
import com.minwei.test.model.icon.Icon;
import com.minwei.test.model.page.properties.AbstractProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import notion.api.v1.model.common.Cover;

import java.util.Date;
import java.util.Map;

/**
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotionPage {

    private String object = "page";

    /**
     * 页面唯一标识
     */
    private String id;

    /**
     * 创建日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date createdTime;

    /**
     * 最后更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date lastEditedTime;

    /**
     * 页面存档状态
     */
    private boolean archived;

    /**
     * 页面是否在垃圾桶中
     */
    private boolean inTrash;

    /**
     * 图标
     */
    private Icon icon;

    /**
     * 封面
     */
    private Cover cover;

    /**
     * 页面属性值
     */
    private Map<String, AbstractProperty> properties;

    /**
     * 父级信息
     */
    private Parent parent;

    /**
     * Notion页面的URL
     */
    private String url;

    /**
     * 公共页面URL,如页面已发布到Web,否则,Null
     */
    private String publicUrl;
}
