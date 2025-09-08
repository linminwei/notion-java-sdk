package com.minwei.test.notion.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.test.notion.model.common.Cover;
import com.minwei.test.notion.model.common.Icon;
import lombok.Data;

/**
 * 外部文件对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class ExternalFile implements File, Icon, Cover {

    @JsonProperty("type")
    private final String type = "external";

    @JsonProperty("name")
    private String name;

    @JsonProperty("external")
    private ExternalFileInfo external;

    @Data
    public static class ExternalFileInfo {

        /** 指向外部托管内容的链接 **/
        @JsonProperty("url")
        private String url;
    }
}
