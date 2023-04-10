package com.orangesummer.mathgenealogy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Data
@AllArgsConstructor
public class MathematicianFindByMid {
    private Long mid;
    private String name;
    private String country;
    private String title;
    private Integer year;
    private String institution;
    private String dissertation;
    private String classification;
    private List<Object> students;
    private List<Object> advisors;

}
