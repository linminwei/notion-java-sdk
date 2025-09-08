package com.minwei.test.model.blocks;

import com.minwei.test.enums.NotionColor;
import com.minwei.test.model.common.richtext.RichText;
import com.minwei.test.model.common.richtext.text.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author lmw
 * 待办事项块
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoBlock extends NotionBlock {

    private TodoContent toDo;

    public TodoBlock(String content) {
        this.toDo = new TodoContent(Collections.singletonList(new Text(content)), false, NotionColor.DEFAULT, null);
    }

    public TodoBlock(String content, boolean checked) {
        this.toDo = new TodoContent(Collections.singletonList(new Text(content)), checked, NotionColor.DEFAULT, null);
    }

    public TodoBlock(String content, NotionColor color) {
        this.toDo = new TodoContent(Collections.singletonList(new Text(content)), false, color, null);
    }

    public TodoBlock(String content, List<NotionBlock> blocks) {
        this.toDo = new TodoContent(Collections.singletonList(new Text(content)), false, NotionColor.DEFAULT, blocks);
    }

    public TodoBlock(String content, NotionColor color, List<NotionBlock> blocks) {
        this.toDo = new TodoContent(Collections.singletonList(new Text(content)), false, color, blocks);
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
