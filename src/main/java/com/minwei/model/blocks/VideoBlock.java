package com.minwei.model.blocks;


import com.minwei.model.common.file.ExternalFile;
import com.minwei.model.common.file.NotionFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoBlock extends NotionBlock{


    private VideoContent video;


    public VideoBlock(String url){
        this.video = new VideoContent(url);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class VideoContent{

        private NotionFile external;

        public VideoContent(String url){
            this.external = new ExternalFile(url);
        }
    }

}
