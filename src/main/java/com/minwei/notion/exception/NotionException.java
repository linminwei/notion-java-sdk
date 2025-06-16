package com.minwei.notion.exception;


/**
 * Notion异常类
 *
 * @author lmw 2025/06/16
 */

public class NotionException extends Exception{

    public NotionException(String message){
        super(message);
    }

    public NotionException(String message, Throwable cause){
        super(message, cause);
    }

}
