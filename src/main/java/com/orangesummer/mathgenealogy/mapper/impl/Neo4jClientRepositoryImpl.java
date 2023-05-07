package com.orangesummer.mathgenealogy.mapper.impl;

import com.orangesummer.mathgenealogy.mapper.Neo4jClientRepository;
import com.orangesummer.mathgenealogy.model.mapstruct.MathematicianMapper;
import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.po.Ranking;
import com.orangesummer.mathgenealogy.model.po.SameClassificationPercentage;
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
public class Neo4jClientRepositoryImpl implements Neo4jClientRepository {
    @Resource
    Neo4jClient client;
    @Resource
    Neo4jMappingContext mappingContext;
    @Resource
    MathematicianMapper mathematicianMapper;

    @Override
    public Optional<MathematicianVO> findByMid(Long mid) {
        BiFunction<TypeSystem, MapAccessor, Mathematician> mappingFunction = mappingContext.getRequiredMappingFunctionFor(Mathematician.class);
        return client
                .query("""
                        match (n{mid:$mid})
                        with n
                        optional match (n)-[:advisorOf]->(s)
                        optional match (n)-[:studentOf]->(a)
                        with n as person, collect(distinct {mid:s.mid, name:s.name, descendant:s.descendant}) as students, collect(distinct {mid:a.mid, name:a.name, descendant:a.descendant}) as advisors
                        return person,
                        case
                            when apoc.coll.contains(students,{name:null, mid:null, descendant:null}) then []
                            else students
                        end as students,
                        case
                            when apoc.coll.contains(advisors,{name:null, mid:null, descendant:null}) then []
                            else advisors
                        end as advisors
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

    @Override
    public Collection<Map<String, Object>> countByAllCountry(String limit) {
        return client
                .query("""
                        match (r)
                        return r.country as country, count(*) as num
                        order by num desc
                        """ + limit)
                .fetch()
                .all();
    }

    @Override
    public Collection<Map<String, Object>> countByAllInstitution() {
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

    @Override
    public Collection<Map<String, Object>> countByAllClassification() {
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

    @Override
    public Collection<Ranking> findTopByDescendant(String query) {
        return client
                .query(query)
                .fetchAs(Ranking.class)
                .mappedBy((TypeSystem t, Record record) -> new Ranking(
                        record.get("mid").asLong(-1),
                        record.get("name").asString(""),
                        record.get("country").asString(""),
                        record.get("classificationId").asInt(-1),
                        record.get("year").asInt(-1),
                        record.get("descendants").asInt(0),
                        record.get("students").asList(v -> new Ranking(
                                v.get("mid").asLong(-1),
                                v.get("name").asString(""),
                                v.get("country").asString(""),
                                v.get("classificationId").asInt(-1),
                                v.get("year").asInt(-1),
                                v.get("descendants").asInt(0), null, null)),
                        record.get("advisors").asList(v -> new Ranking(
                                v.get("mid").asLong(-1),
                                v.get("name").asString(""),
                                v.get("country").asString(""),
                                v.get("classificationId").asInt(-1),
                                v.get("year").asInt(-1),
                                v.get("descendants").asInt(0), null, null))
                ))
                .all();
    }

    @Override
    public Collection<SameClassificationPercentage> getSameClassificationPercentageList() {
        return client
                .query("""
                        match (m1:Mathematician)-[a1:advisorOf]->(s1:Mathematician)
                        with m1.classification as classification, count(a1) as total
                        match (m2:Mathematician)-[a2:advisorOf]->(s2:Mathematician)
                        where m2.classification = classification and m2.classification = s2.classification
                        with m2.classification as classification, count(a2) as different, total
                        return classification, toFloat(different)/toFloat(total) as percent
                        order by classification
                        """)
                .fetchAs(SameClassificationPercentage.class)
                .mappedBy((TypeSystem t, Record record) -> new SameClassificationPercentage(record.get("classification").asInt(), record.get("percent").asDouble()))
                .all();
    }

}
