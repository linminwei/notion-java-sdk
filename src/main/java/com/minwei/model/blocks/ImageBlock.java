package com.minwei.model.blocks;

import com.minwei.model.common.file.ExternalFile;
import com.minwei.model.common.file.NotionFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图像块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageBlock extends NotionBlock {

    private ImageContent image;

    public ImageBlock(String imageUrl) {
        this.image = new ImageContent(imageUrl);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ImageContent {

        private NotionFile external;

        public ImageContent(String imageUrl) {
            this.external = new ExternalFile(imageUrl);
        }

    }

}
