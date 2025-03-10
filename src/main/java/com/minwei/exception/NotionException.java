package com.minwei.exception;

/**
 * Notion异常类
 *
 * @author lmw
 */
public class NotionException extends RuntimeException {

    public NotionException(String message) {
        super(message);
    }

    public NotionException(String message, Throwable cause) {
        super(message, cause);
    }

}
