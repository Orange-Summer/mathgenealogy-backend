package com.orangesummer.mathgenealogy.model.vo;

import lombok.Data;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/23
 */
@Data
public class RankingVO {
    Long mid;
    String name;
    String country;
    String classification;
    Integer year;
    Integer descendants;
}
