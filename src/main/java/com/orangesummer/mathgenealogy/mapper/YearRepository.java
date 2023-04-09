package com.orangesummer.mathgenealogy.mapper;

import jakarta.annotation.Resource;
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
public class YearRepository {
    @Resource
    Neo4jClient client;

    public Collection<Map<String, Object>> getCountryCount(Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician)
                        where m.year >= $start and m.year <= $end and m.country is not null
                        return m.country as country, count(m) as num
                        order by num desc
                        limit 10
                        """)
                .bind(start).to("start")
                .bind(end).to("end")
                .fetch()
                .all();
    }

    public Collection<Map<String, Object>> getClassificationCount(Integer start, Integer end) {
        return client
                .query("""
                        match (m:Mathematician)
                        where m.year >= $start and m.year <= $end and m.classification <> -1
                        return m.classification as classification, count(m) as num
                        order by num desc
                        limit 10
                        """)
                .bind(start).to("start")
                .bind(end).to("end")
                .fetch()
                .all();
    }
}
