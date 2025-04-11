package com.minwei.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lmw
 * Notion Webhook事件传输对象
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotionWebhookDTO {

    /**
     * 事件唯一id
     */
    private String id;

    /**
     * 事件发生的时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX",timezone = "Asia/Shanghai")
    private Date timestamp;

    /**
     * 事件来源的工作区id
     */
    private String workspaceId;

    /**
     * 事件来源工作区名称
     */
    private String workspaceName;

    /**
     * Webhook订阅的id
     */
    private String subscriptionId;

    /**
     * 设置订阅时使用的关联集成id
     */
    private String integrationId;

    /**
     * 事件类型
     */
    private String type;

    /**
     * 事件对象
     */
    private Entity entity;

    /**
     * 附加数据对象
     */
    private Data data;

    @lombok.Data
    public static class Data{

        /**
         * 所属父对象
         */
        private Parent parent;

        @lombok.Data
        public static class Parent {
            private String id;
            private String type;
        }
    }

    @lombok.Data
    public static class Entity {

        /**
         * 所操作主体的id
         */
        private String id;

        /**
         * 所操作主体的类型
         */
        private String type;
    }


}
