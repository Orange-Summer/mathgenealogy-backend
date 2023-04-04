package com.orangesummer.mathgenealogy.model.po;

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
public class MathematicianFindByMid {

    private final Mathematician advisor;

    private final Mathematician student;

}
