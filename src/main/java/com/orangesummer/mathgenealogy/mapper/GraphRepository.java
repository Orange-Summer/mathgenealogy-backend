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
            match (m:Mathematician{mid::#{literal(#mid)}})
            call apoc.path.spanningTree(m, {
            	relationshipFilter: "advisorOf>",
                minLevel: 0,
                maxLevel: :#{literal(#depth)}
            })
            yield path
            with collect(path) as pathList
            call apoc.convert.toTree(pathList)
            yield value
            return value
            union
            match (m:Mathematician{mid::#{literal(#mid)}})
            call apoc.path.spanningTree(m, {
            	relationshipFilter: "studentOf>",
                minLevel: 0,
                maxLevel: :#{literal(#depth)}
            })
            yield path
            with collect(path) as pathList
            call apoc.convert.toTree(pathList)
            yield value
            return value
            """)
    List<Map<String, Object>> findTreeByMid(Long mid, Long depth);

    // 这种查询可能出现重复节点
    // @Query("""
    //         match p = (:Mathematician{mid::#{literal(#mid)}})-[:advisorOf*0..:#{literal(#depth)}]->(:Mathematician)
    //         with collect(p) as paths
    //         call apoc.convert.toTree(paths)
    //         yield value
    //         return value
    //         union
    //         match p = (:Mathematician{mid::#{literal(#mid)}})-[:studentOf*0..:#{literal(#depth)}]->(:Mathematician)
    //         with collect(p) as paths
    //         call apoc.convert.toTree(paths)
    //         yield value
    //         return value
    //         """)

    @Query("""
            match (m:Mathematician{mid::#{literal(#mid)}})
            call apoc.path.spanningTree(m, {
            	relationshipFilter: "advisorOf>",
                minLevel: 0,
                maxLevel: :#{literal(#depth)}
            })
            yield path
            with collect(path) as pathList
            call apoc.convert.toTree(pathList)
            yield value
            return value
            """)
    List<Map<String, Object>> findStudentTreeByMid(Long mid, Long depth);

    @Query("""
            match (m:Mathematician{mid::#{literal(#mid)}})
            call apoc.path.spanningTree(m, {
            	relationshipFilter: "studentOf>",
                minLevel: 0,
                maxLevel: :#{literal(#depth)}
            })
            yield path
            with collect(path) as pathList
            call apoc.convert.toTree(pathList)
            yield value
            return value
            """)
    List<Map<String, Object>> findAdvisorTreeByMid(Long mid, Long depth);
}
