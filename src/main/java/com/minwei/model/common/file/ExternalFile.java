package com.minwei.model.common.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 外部文件对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalFile extends NotionFile {

    private String url;

}
