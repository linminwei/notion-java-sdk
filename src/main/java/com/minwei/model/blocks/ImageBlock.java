package com.minwei.model.blocks;

import com.minwei.model.file.ExternalFile;
import com.minwei.model.file.File;
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
