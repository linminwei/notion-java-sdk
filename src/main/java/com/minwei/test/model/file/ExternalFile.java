package com.minwei.test.model.file;

import com.minwei.test.model.common.richtext.text.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

/**
 * @author lmw
 * 外部文件对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalFile extends File {

    private ExternalFileContent external;

    public ExternalFile(String url) {
        this.external = new ExternalFileContent(url);
    }

    public ExternalFile(String url, String caption, String name) {
        super(Collections.singletonList(new Text((caption))), name);
        this.external = new ExternalFileContent(url);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ExternalFileContent {
        private String url;
    }


}
