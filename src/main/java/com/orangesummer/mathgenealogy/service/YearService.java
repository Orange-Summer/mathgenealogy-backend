package com.orangesummer.mathgenealogy.service;

import com.orangesummer.mathgenealogy.model.vo.ClassificationNumWithYearVO;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/9
 */
public interface YearService {
    Collection<Map<String, Object>> getCountryCount(Integer start, Integer end);

    Collection<Map<String, Object>> getClassificationCount(Integer start, Integer end);

    Collection<ClassificationNumWithYearVO> getClassificationCountWithYear(Integer start, Integer end);
}
