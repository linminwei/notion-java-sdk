package com.minwei.model.icon;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.model.emoji.CustomEmoji;
import com.minwei.model.emoji.NotionEmoji;
import com.minwei.model.file.ExternalFile;
import com.minwei.model.file.NotionFile;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lmw
 */
@Data
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NotionEmoji.class, name = "emoji"),
        @JsonSubTypes.Type(value = CustomEmoji.class, name = "custom_emoji"),
        @JsonSubTypes.Type(value = NotionFile.class, name = "file"),
        @JsonSubTypes.Type(value = ExternalFile.class, name = "external")
})

public abstract class Icon {
}
