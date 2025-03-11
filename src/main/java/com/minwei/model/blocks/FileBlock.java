package com.minwei.model.blocks;

import com.minwei.model.common.RichText;
import com.minwei.model.common.file.ExternalFile;
import com.minwei.model.common.file.NotionFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 文件块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileBlock extends NotionBlock {

    private FileContent file;

    public FileBlock(String caption, String name, String fileUrl) {
        this.file = new FileContent(caption, name, fileUrl);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class FileContent {

        /**
         * 文件块标题
         */
        private List<RichText> caption;

        private String type = "external";

        private NotionFile external;

        /**
         * 文件块名称
         */
        private String name;

        public FileContent(String caption, String name, String fileUrl) {
            this.caption = Collections.singletonList(new RichText(caption));
            this.name = name;
            this.external = new ExternalFile(fileUrl);
        }

    }

}
