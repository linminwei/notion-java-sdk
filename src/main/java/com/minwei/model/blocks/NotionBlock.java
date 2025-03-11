package com.minwei.model.blocks;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.model.common.CreatedBy;
import com.minwei.model.common.LastEditedBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lmw
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BookmarkBlock.class, name = "bookmark"),
        @JsonSubTypes.Type(value = BreadcrumbBook.class, name = "breadcrumb"),
        @JsonSubTypes.Type(value = BulletedListItemBlock.class, name = "bulleted_list_item"),
        @JsonSubTypes.Type(value = CalloutBlock.class, name = "callout"),
        @JsonSubTypes.Type(value = CodeBlock.class, name = "code"),
        @JsonSubTypes.Type(value = DividerBlock.class, name = "divider"),
        @JsonSubTypes.Type(value = EmbedBlock.class, name = "embed"),
        @JsonSubTypes.Type(value = EquationBlock.class, name = "equation"),
        @JsonSubTypes.Type(value = FileBlock.class, name = "file"),
        @JsonSubTypes.Type(value = HeadingOneBlock.class, name = "heading_1"),
        @JsonSubTypes.Type(value = HeadingTwoBlock.class, name = "heading_2"),
        @JsonSubTypes.Type(value = HeadingThreeBlock.class, name = "heading_3"),
        @JsonSubTypes.Type(value = ImageBlock.class, name = "image"),
        @JsonSubTypes.Type(value = NumberListItemBlock.class, name = "numbered_list_item"),
        @JsonSubTypes.Type(value = ParagraphBlock.class, name = "paragraph"),
        @JsonSubTypes.Type(value = QuoteBlock.class, name = "quote"),
        @JsonSubTypes.Type(value = TableOfContentsBlock.class, name = "table_of_contents"),
        @JsonSubTypes.Type(value = TodoBlock.class, name = "to_do"),
        @JsonSubTypes.Type(value = VideoBlock.class, name = "video"),
})
@AllArgsConstructor
@NoArgsConstructor
public abstract class NotionBlock {
    private final String object = "block";
    private String id;

    /**
     * 所属父节点
     */
    private BlockParent parent;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 最后编辑时间
     */
    private String lastEditedTime;

    /**
     * 创建人
     */
    private CreatedBy createdBy;

    /**
     * 最后更新人
     */
    private LastEditedBy lastEditedBy;

    /**
     * 是否有子节点
     */
    private boolean hasChildren;

    /**
     * 是否归档
     */
    private boolean archived;

    /**
     * 是否在回收站
     */
    private boolean inTrash;

    /**
     * 类型
     */
    private String type;


}
