package com.orangesummer.mathgenealogy.util;

import lombok.Getter;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/9
 */
@Getter
public enum ResultCode {

    SUCCESS(1000, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误"),

    NULL_DATA(1003, "结果为空");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}