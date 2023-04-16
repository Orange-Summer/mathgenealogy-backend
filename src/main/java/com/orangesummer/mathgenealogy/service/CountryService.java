package com.orangesummer.mathgenealogy.service;

import com.orangesummer.mathgenealogy.model.vo.ClassificationNumVO;
import com.orangesummer.mathgenealogy.model.vo.ClassificationNumWithYearVO;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/15
 */
public interface CountryService {

    Collection<String> getAllCountry();

    Collection<ClassificationNumVO> getSingleCountryClassification(String country, Integer start, Integer end);

    Collection<Map<String, Object>> getCountryCountLine(String[] countries, Integer start, Integer end);

    Collection<ClassificationNumWithYearVO> getSingleCountryClassificationWithYear(String country, Integer start, Integer end);
}
