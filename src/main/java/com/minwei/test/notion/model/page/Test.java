package com.minwei.test.notion.model.page;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.minwei.test.notion.model.file.ExternalFile;
import com.minwei.test.notion.model.file.File;

/**
 * @author lmw 2025/06/18
 */
public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 序列化时忽略空值
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);


        String json = "{  \n" +
                "  \"type\": \"external\",  \n" +
                "  \"external\": {  \n" +
                "    \"url\": \"https://example.com/photo.png\"  \n" +
                "  }  \n" +
                "}";

        Page page = new Page();
        ExternalFile externalFile1 = new ExternalFile();
        ExternalFile.ExternalFileInfo externalFileInfo = new ExternalFile.ExternalFileInfo();
        externalFileInfo.setUrl("https://example.com/photo.png");
        externalFile1.setExternal(externalFileInfo);
        page.setCover(externalFile1);

        String s = objectMapper.writeValueAsString(externalFile1);
        System.out.println(s);


        try {
            File file = objectMapper.readValue(json, File.class);
            String type = file.getType();
            ExternalFile externalFile = (ExternalFile) file;
            System.out.println(externalFile);
            System.out.println(file);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


//        AudioBlock audioBlock = new AudioBlock();
//
//        String s = objectMapper.writeValueAsString(audioBlock);
//        System.out.println(s);
//        String s = objectMapper.writeValueAsString(block);
//        System.out.println(s);
//        System.out.println(block);


    }
}
