package com.minwei.notion.exception;


/**
 * Notion异常类
 *
 * @author lmw 2025/06/18
 */
public class NotionException extends Exception {

    public NotionException(String message) {
        super(message);
    }

    public NotionException(String message, Throwable cause) {
        super(message, cause);
    }
}
