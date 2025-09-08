package com.minwei.test.notion.model.property;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.test.model.file.File;
import lombok.Data;

import java.util.List;

/**
 * 文件属性
 *
 * @author lmw 2025/06/18
 */
@Data
public class Files implements Property {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private final String type = "files";

    @JsonProperty("files")
    private List<File> files;


}
