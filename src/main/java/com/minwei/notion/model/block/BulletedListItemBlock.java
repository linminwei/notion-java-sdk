package com.minwei.notion.model.block;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.minwei.notion.model.rtf.RichText;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 项目符号列表项块对象
 *
 * @author lmw 2025/06/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BulletedListItemBlock extends Block {

    @JsonProperty("bulleted_list_item")
    private BulletedListItemBlockContent bulletedListItemBlock;

    @Data
    public static class BulletedListItemBlockContent {

        /** 富文本对象数组 **/
        @JsonProperty("rich_text")
        private List<RichText> richTexts;

        /** 块颜色 **/
        private String color;

        /** 块的嵌套子块 **/
        private List<Block> children;

    }

}
