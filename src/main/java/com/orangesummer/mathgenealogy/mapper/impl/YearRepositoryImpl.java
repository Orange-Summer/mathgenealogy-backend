package com.orangesummer.mathgenealogy.mapper.impl;

import com.orangesummer.mathgenealogy.mapper.YearRepository;
import com.orangesummer.mathgenealogy.model.po.ClassificationNumWithYear;
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
 * @date Created on 2023/4/9
 */
@Repository
public class YearRepositoryImpl implements YearRepository {
    @Resource
    Neo4jClient client;

    @Override
    public Collection<Map<String, Object>> countByAllCountryAndYearRange(Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician)
                        where m.year >= $start and m.year <= $end and m.country is not null
                        return m.country as country, count(*) as num
                        order by num desc
                        limit 10
                        """)
                .bind(start).to("start")
                .bind(end).to("end")
                .fetch()
                .all();
    }

    @Override
    public Collection<Map<String, Object>> countByAllClassificationAndYearRange(Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician)
                        where m.year >= $start and m.year <= $end and m.classification <> -1
                        return m.classification as classification, count(*) as num
                        order by num desc
                        limit 10
                        """)
                .bind(start).to("start")
                .bind(end).to("end")
                .fetch()
                .all();
    }

    @Override
    public Collection<ClassificationNumWithYear> countByAllClassificationAndYearRangeWithYear(Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician)
                        where m.year >= $start and m.year <= $end and m.classification <> -1
                        return m.classification as classification, m.year as year, count(*) as num
                        order by year
                        """)
                .bind(start).to("start")
                .bind(end).to("end")
                .fetchAs(ClassificationNumWithYear.class)
                .mappedBy((TypeSystem t, Record record) -> new ClassificationNumWithYear(record.get("classification").asInt(), record.get("year").asInt(), record.get("num").asInt()))
                .all();
    }
}
