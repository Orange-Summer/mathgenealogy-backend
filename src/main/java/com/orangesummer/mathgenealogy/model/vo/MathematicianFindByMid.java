package com.orangesummer.mathgenealogy.model.vo;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@AllArgsConstructor
public class MathematicianFindByMid {
    private final MathematicianVO person;

    private final List<Object> advisors;

    private final List<Object> students;

}
