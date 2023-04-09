package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.Mathematician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
@Repository
public interface BasicRepository extends Neo4jRepository<Mathematician, Long> {
    @Query("match (n:Mathematician{mid:$mid})-[:advisorOf*1..$depth]->(r:Mathematician) return r")
    List<Mathematician> findStudents(Long mid, Integer depth);

    @Query("match (n:Mathematician)-[:advisorOf*1..$depth]->(r:Mathematician{mid:mid}) return n")
    List<Mathematician> findAdvisors(Long mid, Integer depth);

    @Query(value = "match (m) return m order by m.mid asc skip $skip limit $limit", countQuery = "match (m) return count(m)")
    Page<Mathematician> getList(Pageable pageable);
}
