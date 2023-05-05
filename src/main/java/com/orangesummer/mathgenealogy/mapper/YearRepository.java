package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/9
 */
@Repository
public interface YearRepository {
    Collection<Map<String, Object>> getCountryCount(Integer start, Integer end);

    Collection<Map<String, Object>> getClassificationCount(Integer start, Integer end);

    Collection<ClassificationNumWithYear> getClassificationCountWithYear(Integer start, Integer end);
}
