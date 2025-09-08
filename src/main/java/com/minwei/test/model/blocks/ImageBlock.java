package com.minwei.test.model.blocks;

import com.minwei.test.model.file.ExternalFile;
import com.minwei.test.model.file.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 图像块
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageBlock extends NotionBlock {

    private File image;

    public ImageBlock(String url) {
        this.image = new ExternalFile(url);
    }

}
