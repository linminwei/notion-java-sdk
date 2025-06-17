package com.minwei.notion.model.rtf;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.notion.model.common.NotionDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 日期提及对象
 *
 * @author lmw 2025/06/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MentionDate extends Mention {

    /** Notion日期对象 **/
    @JsonProperty("date")
    private NotionDate date;

}
