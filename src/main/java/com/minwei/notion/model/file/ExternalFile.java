package com.minwei.notion.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 外部文件对象
 *
 * @author lmw 2025/06/16
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ExternalFile extends File {

    @JsonProperty("external")
    private ExternalElement external;


    /**
     * 外部文件内容节点
     */
    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ExternalElement {
        /** 指向外部托管内容的链接 **/
        @JsonProperty("url")
        private String url;
    }


}
