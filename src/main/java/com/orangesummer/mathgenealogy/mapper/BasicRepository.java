package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.Mathematician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Repository
public interface BasicRepository extends Neo4jRepository<Mathematician, Long> {
    @Query(value = "match (m) return m order by m.mid asc skip $skip limit $limit", countQuery = "match (m) return count(m)")
    Page<Mathematician> findList(Pageable pageable);

    @Query("""
            match (m:Mathematician)
            where m.country is not null
            with m.country as country, count(*) as num
            return country
            order by num desc
            """)
    Collection<String> findAllCountry();

    @Query("""
            match (m:Mathematician)
            where m.classification <> -1
            with m.classification as classification, count(*) as num
            return classification
            order by num desc
            """)
    Collection<Long> findAllClassification();
}
