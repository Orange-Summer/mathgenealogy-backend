package com.orangesummer.mathgenealogy.model.vo;

import com.orangesummer.mathgenealogy.model.po.Mathematician;
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
    private String year;
    private String institution;
    private String dissertation;
    private Integer classification;
    private List<Mathematician> students;
    private List<Mathematician> advisors;

}
