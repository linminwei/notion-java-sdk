package com.minwei.model.blocks;

import com.minwei.model.common.richtext.RichText;
import com.minwei.model.common.richtext.text.Text;
import com.minwei.model.file.ExternalFile;
import com.minwei.model.file.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author lmw
 * PDF块
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdfBlock extends NotionBlock {

    private List<RichText> caption;

    private File pdf;

    public PdfBlock(String caption, String url) {
        this.caption = Collections.singletonList(new Text(caption));
        this.pdf = new ExternalFile(url);
    }


}
