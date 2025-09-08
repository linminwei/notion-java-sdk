package com.minwei.api.model.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Notion外部文件对象
 *
 * @author lmw 2025/09/08
 */
@Data
public class ExternalFile extends File {

    @JsonProperty("external.url")
    private String url;

}
