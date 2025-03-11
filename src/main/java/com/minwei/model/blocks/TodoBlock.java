package com.minwei.model.blocks;

import com.minwei.enums.NotionColor;
import com.minwei.model.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 待办事项块对象
 *
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoBlock extends NotionBlock {

    private TodoContent toDo;


    public TodoBlock(String content, boolean checked) {
        this(new TodoContent(Collections.singletonList(new RichText(content)), checked, NotionColor.DEFAULT, null));
    }

    public TodoBlock(String content, boolean checked, NotionColor color) {
        this(new TodoContent(Collections.singletonList(new RichText(content)), checked, color, null));
    }

    public TodoBlock(String content, boolean checked, NotionColor color, List<NotionBlock> blocks) {
        this(new TodoContent(Collections.singletonList(new RichText(content)), checked, color, blocks));
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TodoContent {

        private List<RichText> richText;

        private boolean checked;

        private NotionColor color;

        private List<NotionBlock> children;
    }

}
