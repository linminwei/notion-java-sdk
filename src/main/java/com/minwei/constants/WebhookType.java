package com.minwei.constants;

/**
 * @author lmw
 */
public class WebhookType {

    /**
     * 页面内容更新事件
     */
    public static final String PAGE_CONTENT_UPDATE = "page.content_updated";

    /**
     * 创建页面事件
     */
    public static final String PAGE_CREATED = "page.created";

    /**
     * 删除页面事件
     */
    public static final String PAGE_DELETE = "page.deleted";

    /**
     * 恢复删除页面事件
     */
    public static final String PAGE_UNDELETED = "page.undeleted";

    /**
     * 锁定页面事件
     */
    public static final String PAGE_LOCKED = "page.locked";

    /**
     * 锁定页面事件
     */
    public static final String PAGE_UNLOCKED = "page.unlocked";

    /**
     * 页面移动事件
     */
    public static final String PAGE_MOVED = "page.moved";

    /**
     * 页面属性更新事件
     */
    public static final String PAGE_PROPERTIES_UPDATED = "page.properties_updated";

    /**
     * 更新数据库内容事件：如添加或删除子页面
     */
    public static final String DATABASE_CONTENT_UPDATED = "database.content_updated";

    /**
     * 创建数据库事件
     */
    public static final String DATABASE_CREATED = "database.created";

    /**
     * 删除数据库事件
     */
    public static final String DATABASE_DELETED = "database.deleted";

    /**
     * 恢复删除的数据库事件
     */
    public static final String DATABASE_UNDELETED = "database.undeleted";

    /**
     * 移动数据库事件
     */
    public static final String DATABASE_MOVED = "database.moved";

    /**
     * 更新数据库结构时触发，如：添加/删除数据库属性
     */
    public static final String DATABASE_SCHEMA_UPDATED = "database.schema_updated";

    /**
     * 新增评论事件
     */
    public static final String COMMENT_CREATED = "comment.created";

    /**
     * 删除评论事件
     */
    public static final String COMMENT_DELETED = "comment.deleted";

    /**
     * 编辑评论事件
     */
    public static final String COMMENT_UPDATED = "comment.updated";
}
