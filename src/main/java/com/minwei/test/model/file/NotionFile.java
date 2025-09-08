package com.minwei.test.model.file;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotionFile extends File {

    private NotionFileContent file;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class NotionFileContent {

        private String url;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
        private Date expiryTime;
    }


}
