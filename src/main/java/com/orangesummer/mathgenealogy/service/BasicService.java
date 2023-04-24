package com.orangesummer.mathgenealogy.service;

import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import com.orangesummer.mathgenealogy.model.vo.MathematicianFindByMid;
import com.orangesummer.mathgenealogy.model.vo.RankingVO;
import com.orangesummer.mathgenealogy.model.vo.SameClassificationPercentageVO;
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

    MathematicianFindByMid getMathematician(Long mid);

    Collection<Map<String, Object>> getCountryCount();

    Collection<Map<String, Object>> getInstitutionCount();

    Collection<Map<String, Object>> getClassificationCount();

    Collection<String> getAllCountry();

    Collection<String> getAllClassification();

    Collection<RankingVO> getRanking(String[] countries, String[] classifications, Integer start, Integer end, Integer limit);

    Collection<SameClassificationPercentageVO> getSameClassificationPercentage();
}
