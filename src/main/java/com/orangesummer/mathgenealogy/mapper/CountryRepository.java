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
    Collection<ClassificationNum> getSingleCountryClassification(String country, Integer start, Integer end);

    Collection<Map<String, Object>> getSingleCountryCount(String country, Integer start, Integer end);

    Collection<ClassificationNumWithYear> getSingleCountryClassificationWithYear(String country, Integer start, Integer end);

    Collection<KnowledgeFlow> getKnowledgeFlowOut(String country, Integer start, Integer end);

    Collection<KnowledgeFlow> getKnowledgeFlowIn(String country, Integer start, Integer end);

}
