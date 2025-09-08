package com.minwei.api.response.page;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.api.model.file.File;
import com.minwei.api.response.NotionResponse;
import lombok.Data;

import java.util.Date;

/**
 * Notion检索页面响应对象
 *
 * @author lmw 2025/09/08
 */
@Data
public class RetrievePageResponse extends NotionResponse {

    private String id;

    // 创建时间
    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date createdTime;

    // 最后编辑时间
    @JsonProperty("last_edited_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date lastEditedTime;

    // 页面的存档状态
    private Boolean archived;

    // 页面是否位于回收站中
    @JsonProperty("in_trash")
    private boolean inTrash;

    // 页面图标
    private File icon;
}
