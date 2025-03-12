package com.minwei.model.blocks;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.minwei.model.common.parent.Parent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 块对象抽象
 *
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
        @JsonSubTypes.Type(value = BreadcrumbBlock.class, name = "breadcrumb"),
        @JsonSubTypes.Type(value = BulletedListItemBlock.class, name = "bulleted_list_item"),
        @JsonSubTypes.Type(value = CalloutBlock.class, name = "callout"),
        @JsonSubTypes.Type(value = ChildDatabaseBlock.class, name = "child_database"),
        @JsonSubTypes.Type(value = ChildPageBlock.class, name = "child_page"),
        @JsonSubTypes.Type(value = CodeBlock.class, name = "code"),
        @JsonSubTypes.Type(value = DividerBlock.class, name = "divider"),
        @JsonSubTypes.Type(value = EmbedBlock.class, name = "embed"),
        @JsonSubTypes.Type(value = EquationBlock.class, name = "equation"),
        @JsonSubTypes.Type(value = FileBlock.class, name = "file"),
})
@AllArgsConstructor
@NoArgsConstructor
public abstract class NotionBlock {

    private final String object = "block";

    /**
     * 块标识符
     */
    private String id;

    /**
     * 块的父级信息
     */
    private Parent parent;

    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date createdTime;

    /**
     * 最后编辑时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date lastEditedTime;

    /**
     * 是否归档
     */
    private boolean archived;

    /**
     * 块是否已删除
     */
    private boolean inTrash;

    /**
     * 块中是否嵌套children
     */
    private boolean hasChildren;

    private String type;
}
