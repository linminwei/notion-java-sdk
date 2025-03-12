package com.minwei.model.emoji;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.model.icon.Icon;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lmw
 * emoji表情抽象类
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NotionEmoji.class, name = "emoji"),
        @JsonSubTypes.Type(value = CustomEmoji.class, name = "custom_emoji")
})
@Data
@AllArgsConstructor
public abstract class Emoji extends Icon {
}
