package com.minwei.test.model.blocks;

import com.minwei.test.model.file.ExternalFile;
import com.minwei.test.model.file.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 文件块对象
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileBlock extends NotionBlock {

    private File file;

    public FileBlock(String title, String url, String name) {
        this.file = new ExternalFile(url, title, name);
    }

}
