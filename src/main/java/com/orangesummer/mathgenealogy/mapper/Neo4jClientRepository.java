package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.mapstruct.MathematicianMapper;
import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.vo.MathematicianVO;
import jakarta.annotation.Resource;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.MapAccessor;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.mapping.Neo4jMappingContext;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
@Repository
public class Neo4jClientRepository {
    @Resource
    Neo4jClient client;
    @Resource
    Neo4jMappingContext mappingContext;
    @Resource
    MathematicianMapper mathematicianMapper;

    public Optional<MathematicianVO> findByMid(Long mid) {
        BiFunction<TypeSystem, MapAccessor, Mathematician> mappingFunction = mappingContext.getRequiredMappingFunctionFor(Mathematician.class);
        return client
                .query("""
                        match (n{mid:$mid})
                        with n
                        match (n)-[:advisorOf]->(s)
                        match (n)-[:studentOf]->(a)
                        return n as person, collect(distinct {mid:s.mid,name:s.name}) as students, collect(distinct {mid:a.mid,name:a.name}) as advisors
                        """)
                .bind(mid).to("mid")
                .fetchAs(MathematicianVO.class)
                .mappedBy((TypeSystem t, Record record) -> {
                    MathematicianVO person = mathematicianMapper.toMathematicianVO(mappingFunction.apply(t, record.get("person").asNode()));
                    person.setAdvisors(record.get("advisors").asList());
                    person.setStudents(record.get("students").asList());
                    return person;
                }).first();
    }

    public Collection<Map<String, Object>> getCountryCount() {
        return client
                .query("""
                        match (r)
                        return r.country as country, count(*) as num
                        order by num desc
                        limit 25
                        """)
                .fetch()
                .all();
    }

    public Collection<Map<String, Object>> getInstitutionCount() {
        return client
                .query("""
                        match (r)
                        where r.institution <> ''
                        return r.institution as institution, count(*) as num
                        order by num desc
                        limit 25
                        """)
                .fetch()
                .all();
    }

    public Collection<Map<String, Object>> getClassificationCount() {
        return client
                .query("""
                        match (r)
                        where r.classification <> -1
                        return r.classification as classification, count(*) as num
                        order by num desc
                        limit 25
                        """)
                .fetch()
                .all();
    }

}
