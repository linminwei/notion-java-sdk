package com.minwei.notion.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 外部文件对象
 *
 * @author lmw 2025/06/18
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ExternalFile extends File {

    @JsonProperty("external")
    private ExternalFileContent external;


    /**
     * 外部文件对象内容
     */
    @Data
    public static class ExternalFileContent {

        /** 指向外部托管内容的链接 **/
        @JsonProperty("url")
        private String url;
    }

}
