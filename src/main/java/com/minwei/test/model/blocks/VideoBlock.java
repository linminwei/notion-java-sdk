package com.minwei.test.model.blocks;

import com.minwei.test.model.file.ExternalFile;
import com.minwei.test.model.file.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 * 视频块对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoBlock extends NotionBlock {

    File video;

    public VideoBlock(String url) {
        this.video = new ExternalFile(url);
    }

}
