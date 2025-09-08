package com.minwei.enums;


/**
 * Notion错误码枚举
 *
 * @author lmw 2025/09/08
 */

public enum NotionErrorCode {

    INVALID_JSON("invalid_json","无法将请求正文解码为JSON"),

    INVALID_REQUEST_URL("invalid_request_url","请求的URL无效"),

    INVALID_REQUEST("invalid_request","不支持此请求"),

    INVALID_GRANT("invalid_grant","提供的授权或刷新令牌无效"),

    VALIDATION_ERROR("validation_error","请求正文与预期的参数结构不匹配"),

    MISSING_VERSION("missing_version","缺少所需的请求标头"),

    UNAUTHORIZED("unauthorized","持有者令牌无效"),

    RESTRICTED_RESOURCE("restricted_resource","给定使用的令牌,客户端无权执行此操作"),

    OBJECT_NOT_FOUND("object_not_found","给定使用的令牌，资源不存在。此错误还可能表示资源尚未与持有者令牌的所有者共享"),

    CONFLICT_ERROR("conflict_error","事务无法完成，可能是由于数据冲突。确保参数是最新的，然后重试。极少数情况下，当文件上传第三方数据存储提供商出现停机且发送文件内容失败时，也会提示此信息"),

    RATE_LIMITED("rate_limited","此请求超出了允许的请求数"),

    INTERNAL_SERVER_ERROR("internal_server_error","发生以外错误，请联系Notion支持"),

    BAD_GATEWAY("bad_gateway","Notion在尝试完成此请求时遇到问题，请重试"),

    SERVICE_UNAVAILABLE("service_unavailable","Notion不可用"),

    DATABASE_CONNECTION_UNAVAILABLE("database_connection_unavailable","Notion的数据库不可用或不处于可查询的状态，请稍后重试"),

    GATEWAY_TIMEOUT("gateway_timeout","Notion在尝试完成此请求时超时，请稍后重试");

    // 状态码
    private String code;

    // 描述
    private String desc;

    NotionErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescription(String code) {
        for (NotionErrorCode value : NotionErrorCode.values()) {
            if (value.code.equals(code)) {
                return value.desc;
            }
        }
        return code;
    }

}
