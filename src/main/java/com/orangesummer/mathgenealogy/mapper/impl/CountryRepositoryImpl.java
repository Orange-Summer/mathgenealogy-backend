package com.orangesummer.mathgenealogy.mapper.impl;

import com.orangesummer.mathgenealogy.mapper.CountryRepository;
import com.orangesummer.mathgenealogy.model.po.ClassificationNum;
import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
import com.orangesummer.mathgenealogy.model.po.KnowledgeFlow;
import jakarta.annotation.Resource;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.Neo4jClient;
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
public class CountryRepositoryImpl implements CountryRepository {
    @Resource
    Neo4jClient client;

    @Override
    public Collection<ClassificationNum> countByCountryAndAllClassificationAndYearRange(String country, Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician{country:$country})
                        where m.year >= $start and m.year <= $end and m.classification <> -1
                        return m.classification as classification, count(*) as num
                        order by num desc
                        limit 10
                         """)
                .bind(country).to("country")
                .bind(start).to("start")
                .bind(end).to("end")
                .fetchAs(ClassificationNum.class)
                .mappedBy((TypeSystem t, Record record) -> new ClassificationNum(record.get("classification").asInt(), record.get("num").asInt()))
                .all();
    }

    @Override
    public Collection<Map<String, Object>> countByCountryAndYearRangeWithYear(String country, Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician{country:$country})
                        where m.year >= $start and m.year <= $end
                        return m.country as country, m.year as year, count(*) as num
                        order by year
                        """)
                .bind(country).to("country")
                .bind(start).to("start")
                .bind(end).to("end")
                .fetch()
                .all();

    }

    @Override
    public Collection<ClassificationNumWithYear> countByCountryAndAllClassificationAndYearRangeWithYear(String country, Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician{country:$country})
                        where m.year >= $start and m.year <= $end and m.classification <> -1
                        return m.classification as classification, m.year as year, count(*) as num
                        order by year
                        """)
                .bind(country).to("country")
                .bind(start).to("start")
                .bind(end).to("end")
                .fetchAs(ClassificationNumWithYear.class)
                .mappedBy((TypeSystem t, Record record) -> new ClassificationNumWithYear(record.get("classification").asInt(), record.get("year").asInt(), record.get("num").asInt()))
                .all();

    }

    @Override
    public Collection<KnowledgeFlow> findKnowledgeFlowOut(String country, Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician)-[:advisorOf]->(s)
                        where m.country = $country
                            and m.year >= $start
                            and m.year <= $end
                            and s.country is not null
                            and apoc.node.degree(m, "advisorOf>") > 1
                        with m, s
                        where not exists {
                            match (m:Mathematician)-[:advisorOf]->(s1)
                            where m.country=s1.country
                        } and not exists {
                            match (s2)<-[:advisorOf]-(m:Mathematician)-[:advisorOf]->(s3)
                            where s2.country<>s3.country
                        }
                        return distinct m.country as from, s.country as to
                        """)
                .bind(country).to("country")
                .bind(start).to("start")
                .bind(end).to("end")
                .fetchAs(KnowledgeFlow.class)
                .mappedBy((TypeSystem t, Record record) -> new KnowledgeFlow(record.get("from").asString(), record.get("to").asString()))
                .all();
    }

    @Override
    public Collection<KnowledgeFlow> findKnowledgeFlowIn(String country, Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician)-[:advisorOf]->(s)
                        where s.country = $country
                            and s.year >= $start
                            and s.year <= $end
                            and m.country is not null
                            and apoc.node.degree(m, "advisorOf>") > 1
                        with m, s
                        where not exists {
                            match (m:Mathematician)-[:advisorOf]->(s1)
                            where m.country=s1.country
                        } and not exists {
                            match (s2)<-[:advisorOf]-(m:Mathematician)-[:advisorOf]->(s3)
                            where s2.country<>s3.country
                        }
                        return distinct m.country as from, s.country as to
                        """)
                .bind(country).to("country")
                .bind(start).to("start")
                .bind(end).to("end")
                .fetchAs(KnowledgeFlow.class)
                .mappedBy((TypeSystem t, Record record) -> new KnowledgeFlow(record.get("from").asString(), record.get("to").asString()))
                .all();
    }

}
