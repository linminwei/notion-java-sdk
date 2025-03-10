package com.minwei.model.response;

import lombok.Data;

/**
 * @author lmw
 */
@Data
public class NotionErrorResponse {

    private String object;

    private String status;

    private String code;

    private String message;

    private String requestId;

}
