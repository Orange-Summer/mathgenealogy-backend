package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.ClassificationNum;
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
 * @date Created on 2023/4/15
 */
@Repository
public class CountryRepository {
    @Resource
    Neo4jClient client;

    public Collection<String> getAllCountry() {
        return client
                .query("""
                        match (m:Mathematician)
                        where m.country is not null
                        with m.country as country, count(*) as num
                        return country
                        order by num desc
                         """)
                .fetchAs(String.class)
                .mappedBy((TypeSystem t, Record record) -> record.get("country").asString())
                .all();
    }

    public Collection<ClassificationNum> getSingleCountryClassification(String country, Integer start, Integer end) {
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

    public Collection<Map<String, Object>> getSingleCountryCount(String country, Integer start, Integer end) {
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

    public Collection<ClassificationNumWithYear> getSingleCountryClassificationWithYear(String country, Integer start, Integer end) {
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


}
