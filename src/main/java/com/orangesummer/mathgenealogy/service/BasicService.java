package com.orangesummer.mathgenealogy.service;

import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
public interface BasicService {
    Page<MathematicianVO> allMathematicians(Integer page, Integer size);

    MathematicianVO getMathematician(Long mid);

    Collection<Map<String, Object>> getCountryCount();

    Collection<Map<String, Object>> getInstitutionCount();

    Collection<Map<String, Object>> getClassificationCount();
}
