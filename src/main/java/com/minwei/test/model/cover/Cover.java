package com.minwei.test.model.cover;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.test.model.file.ExternalFile;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 封面对象
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
        @JsonSubTypes.Type(value = ExternalFile.class, name = "external")
})
public abstract class Cover {
}
