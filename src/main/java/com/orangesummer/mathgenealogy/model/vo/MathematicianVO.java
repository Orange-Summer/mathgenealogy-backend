package com.orangesummer.mathgenealogy.model.vo;

import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Data
public class MathematicianVO {
    private Long mid;
    private String name;
    private String country;
    private String title;
    private Integer year;
    private String institution;
    private String dissertation;
    private Integer classification;
    private Integer descendant;
    private List<Object> students;
    private List<Object> advisors;

}
