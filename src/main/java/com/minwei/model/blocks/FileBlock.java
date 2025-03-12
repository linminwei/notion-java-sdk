package com.minwei.model.blocks;

import com.minwei.model.common.richtext.RichText;
import com.minwei.model.file.ExternalFile;
import com.minwei.model.file.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class FileContent {

        /**
         * 文件块标题
         */
        private List<RichText> caption;

        /**
         * 文件对象
         */
        private File file;

        /**
         * 文件块名称
         */
        private String name;
    }


}
