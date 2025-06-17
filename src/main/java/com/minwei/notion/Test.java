package com.minwei.notion;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.minwei.notion.model.block.AudioBlock;

/**
 * @author lmw 2025/06/16
 */
public class Test {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 序列化时忽略空值
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

//        String json = "{\n" +
//                "\t\"object\": \"block\",\n" +
//                "\t\"id\": \"c02fc1d3-db8b-45c5-a222-27595b15aea7\",\n" +
//                "\t\"parent\": {\n" +
//                "\t\t\"type\": \"page_id\",\n" +
//                "\t\t\"page_id\": \"59833787-2cf9-4fdf-8782-e53db20768a5\"\n" +
//                "\t},\n" +
//                "\t\"created_time\": \"2022-03-01T19:05:00.000Z\",\n" +
//                "\t\"last_edited_time\": \"2022-07-06T19:41:00.000Z\",\n" +
//                "\t\"created_by\": {\n" +
//                "\t\t\"object\": \"user\",\n" +
//                "\t\t\"id\": \"ee5f0f84-409a-440f-983a-a5315961c6e4\"\n" +
//                "\t},\n" +
//                "\t\"last_edited_by\": {\n" +
//                "\t\t\"object\": \"user\",\n" +
//                "\t\t\"id\": \"ee5f0f84-409a-440f-983a-a5315961c6e4\"\n" +
//                "\t},\n" +
//                "\t\"has_children\": false,\n" +
//                "\t\"archived\": false,\n" +
//                "\t\"in_trash\": false,\n" +
//                "\t\"color\": \"default\",\n" +
//                "\t\"type\": \"bulleted_list_item\",\n" +
//                "\t\"bulleted_list_item\": {\n" +
//                "\t\t\"rich_text\": [{\n" +
//                "\t\t\t\"type\": \"text\",\n" +
//                "\t\t\t\"text\": {\n" +
//                "\t\t\t\t\"content\": \"Lacinato kale\",\n" +
//                "\t\t\t\t\"link\": null\n" +
//                "\t\t\t}\n" +
//                "\t\t}],\n" +
//                "\t\t\"color\": \"default\",\n" +
//                "\t\t\"children\": [{\n" +
//                "\t\t\t\"type\": \"breadcrumb\",\n" +
//                "\t\t\t\"breadcrumb\": {}\n" +
//                "\t\t}]\n" +
//                "\t},\n" +
//                "\t\"is_toggleable\": false\n" +
//                "}";
//        // 序列化
//        Block block = objectMapper.readValue(json, Block.class);

        AudioBlock audioBlock = new AudioBlock();

        String s = objectMapper.writeValueAsString(audioBlock);
        System.out.println(s);
//        String s = objectMapper.writeValueAsString(block);
//        System.out.println(s);
//        System.out.println(block);
    }
}
