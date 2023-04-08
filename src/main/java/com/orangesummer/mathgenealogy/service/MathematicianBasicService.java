package com.orangesummer.mathgenealogy.service;

import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.ResultVO;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
public interface MathematicianBasicService {
    ResultVO<Page<MathematicianVO>> allMathematicians(Integer page, Integer size);

    ResultVO<MathematicianVO> getMathematician(Long mid);

    ResultVO<Collection<Map<String, Object>>> getCountryCount();

    ResultVO<Collection<Map<String, Object>>> getInstitutionCount();

    ResultVO<Collection<Map<String, Object>>> getClassificationCount();
}
