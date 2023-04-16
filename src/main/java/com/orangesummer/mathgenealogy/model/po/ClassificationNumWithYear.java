package com.orangesummer.mathgenealogy.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/16
 */
@Data
@AllArgsConstructor
public class ClassificationNumWithYear {
    private Integer classificationId;
    private Integer year;
    private Integer num;
}
