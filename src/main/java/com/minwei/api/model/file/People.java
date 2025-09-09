package com.minwei.api.model.file;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.test.notion.model.property.Date;
import lombok.Data;

/**
 * @author lmw 2025/09/09
 */
public class People {

    private Test file;


    public String getType() {
        return file.getType();
    }

    public String getUrl() {
        return file.getUrl();
    }

    public Date getExpiryTime() {
        return file.getExpiryTime();
    }

    @Data
    private static class Test {
        private String type;

        @JsonProperty("url")
        private String url;

        @JsonProperty("expiry_time")
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
        private Date expiryTime;
    }


}
