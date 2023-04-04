package com.orangesummer.mathgenealogy.model.vo;

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
}
