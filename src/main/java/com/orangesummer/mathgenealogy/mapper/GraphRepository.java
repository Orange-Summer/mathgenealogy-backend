package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.Mathematician;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/4
 */
@Repository
public interface GraphRepository extends Neo4jRepository<Mathematician, Long> {
    @Query("""
            match p = (:Mathematician{mid::#{literal(#mid)}})-[:advisorOf*0..:#{literal(#depth)}]->(:Mathematician)
            with collect(p) as paths
            call apoc.convert.toTree(paths)
            yield value
            return value
            union
            match p = (:Mathematician{mid::#{literal(#mid)}})-[:studentOf*0..:#{literal(#depth)}]->(:Mathematician)
            with collect(p) as paths
            call apoc.convert.toTree(paths)
            yield value
            return value
            """)
    List<Map<String, Object>> findTreeByMid(Long mid, Long depth);
}
