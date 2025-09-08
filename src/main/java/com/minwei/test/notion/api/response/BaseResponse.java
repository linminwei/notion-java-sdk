package com.minwei.test.notion.api.response;


import lombok.Data;

/**
 * 基础响应对象
 *
 * @author lmw 2025/06/18
 */
@Data
public abstract class BaseResponse {

    /**
     * 响应状态码
     */
    private Integer status;

    /**
     * 响应编码
     */
    private String code;

    /**
     * 响应描述
     */
    private String message;


    public Boolean isSuccess() {
        return status == 200;
    }

}
