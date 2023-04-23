package com.orangesummer.mathgenealogy.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/23
 */
@Data
@AllArgsConstructor
public class Ranking {
    Long mid;
    String name;
    String country;
    Integer classificationId;
    Integer year;
    Integer descendants;
}
