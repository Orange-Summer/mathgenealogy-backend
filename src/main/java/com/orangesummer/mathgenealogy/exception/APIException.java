package com.orangesummer.mathgenealogy.exception;

import com.orangesummer.mathgenealogy.util.ResultCode;
import lombok.Getter;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/9
 */
@Getter
public class APIException extends RuntimeException {
    private final int code;
    private final String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public APIException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
}
