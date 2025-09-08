package com.minwei.api.response;


import lombok.Setter;

import java.io.Serializable;

/**
 * Notion响应对象
 *
 * @author lmw 2025/09/08
 */
@Setter
public abstract class NotionResponse implements Serializable {

    private Boolean success;

    private String message;


    public Boolean isSuccess() {
        return success;
    }

}
