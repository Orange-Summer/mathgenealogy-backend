package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.Ranking;
import com.orangesummer.mathgenealogy.model.po.SameClassificationPercentage;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
@Repository
public interface Neo4jClientRepository {
    Optional<MathematicianVO> findByMid(Long mid);

    Collection<Map<String, Object>> countByAllCountry(String limit);

    Collection<Map<String, Object>> countByAllInstitution();

    Collection<Map<String, Object>> countByAllClassification();

    Collection<Ranking> findTopByDescendant(String query);

    Collection<SameClassificationPercentage> getSameClassificationPercentageList();

}
