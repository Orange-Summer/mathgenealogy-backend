package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.ClassificationNum;
import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
import com.orangesummer.mathgenealogy.model.po.KnowledgeFlow;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/15
 */
@Repository
public interface CountryRepository {
    Collection<ClassificationNum> countByCountryAndAllClassificationAndYearRange(String country, Integer start, Integer end);

    Collection<Map<String, Object>> countByCountryAndYearRangeWithYear(String country, Integer start, Integer end);

    Collection<ClassificationNumWithYear> countByCountryAndAllClassificationAndYearRangeWithYear(String country, Integer start, Integer end);

    Collection<KnowledgeFlow> findKnowledgeFlowOut(String country, Integer start, Integer end);

    Collection<KnowledgeFlow> findKnowledgeFlowIn(String country, Integer start, Integer end);

}
