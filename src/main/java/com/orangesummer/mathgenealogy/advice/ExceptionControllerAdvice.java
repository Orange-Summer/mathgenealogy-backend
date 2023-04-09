package com.orangesummer.mathgenealogy.advice;

import com.orangesummer.mathgenealogy.exception.APIException;
import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/9
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e) {
        // 返回类型是自定义响应体
        return new ResultVO<>(e.getCode(), "响应失败", e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 返回类型是自定义响应体
        return new ResultVO<>(1001, "参数校验失败", objectError.getDefaultMessage());
    }
}