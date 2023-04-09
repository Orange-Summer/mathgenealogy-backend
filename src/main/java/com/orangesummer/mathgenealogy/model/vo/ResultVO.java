package com.orangesummer.mathgenealogy.model.vo;

import com.orangesummer.mathgenealogy.util.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Data
@AllArgsConstructor
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
