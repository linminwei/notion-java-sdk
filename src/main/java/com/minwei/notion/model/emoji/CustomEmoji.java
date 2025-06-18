package com.minwei.notion.model.emoji;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.notion.model.common.Icon;
import lombok.Data;

/**
 * 自定义 Emoji 对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class CustomEmoji implements Emoji, Icon {

    @JsonProperty("type")
    private final String type = "custom_emoji";

    @JsonProperty("custom_emoji")
    private CustomEmojiInfo customEmoji;


    @Data
    public static class CustomEmojiInfo {

        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }

}
