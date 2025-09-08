package com.minwei.test.notion.model.emoji;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.test.notion.model.common.Icon;
import lombok.Data;

/**
 * Notion Emoji 对象
 *
 * @author lmw 2025/06/18
 */
@Data
public class NotionEmoji implements Emoji, Icon {

    @JsonProperty("type")
    private final String type = "emoji";

    @JsonProperty("emoji")
    private String emoji;

}
