package com.orangesummer.mathgenealogy.model.vo;

import lombok.Data;

import java.util.List;

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
    List<RankingVO> students;
    List<RankingVO> advisors;
}
