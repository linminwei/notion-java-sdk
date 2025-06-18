package com.minwei.notion.model.page;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.notion.model.common.Cover;
import com.minwei.notion.model.common.Icon;
import com.minwei.notion.model.property.Property;
import lombok.Data;

import java.util.Date;

/**
 * Notion页面对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class Page {

    @JsonProperty("object")
    private String object;

    /** 页面唯一标识符 **/
    @JsonProperty("id")
    private String id;

    /** 创建时间 **/
    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date createdTime;

    /** 更新时间 **/
    @JsonProperty("last_edited_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date lastEditedTime;

    /** 页面的存档状态 **/
    @JsonProperty("archived")
    private Boolean archived;

    /** 页面是否在垃圾箱中 **/
    @JsonProperty("in_trash")
    private Boolean inTrash;

    /** 页面的图标 **/
    @JsonProperty("icon")
    private Icon icon;

    /** 页面封面图片 **/
    @JsonProperty("cover")
    private Cover cover;

    private Property property;


}
