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

    Collection<Map<String, Object>> getCountryCount();

    Collection<Map<String, Object>> getInstitutionCount();

    Collection<Map<String, Object>> getClassificationCount();

    Collection<Ranking> getRanking(String query);

    Collection<SameClassificationPercentage> getSameClassificationPercentage();

}
