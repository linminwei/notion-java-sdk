package com.minwei.test.notion.enums;


import lombok.Getter;

/**
 * 文件上传状态
 *
 * @author lmw 2025/06/18
 */
@Getter
public enum FileUploadEnum {

    PENDING("pending","上传中"),
    uploaded("uploaded","已上传"),
    EXPIRED("expired","文件过期"),
    FAILED("failed","上传失败");

    /** 状态编码 **/
    private final String code;

    /** 状态描述 **/
    private final String desc;


    FileUploadEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
