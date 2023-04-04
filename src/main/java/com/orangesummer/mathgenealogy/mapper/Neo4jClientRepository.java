package com.orangesummer.mathgenealogy.mapper;

import com.orangesummer.mathgenealogy.model.po.Mathematician;
import com.orangesummer.mathgenealogy.model.po.MathematicianFindByMid;
import jakarta.annotation.Resource;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.MapAccessor;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.mapping.Neo4jMappingContext;
import org.springframework.stereotype.Repository;

import java.util.Collection;
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

    public Collection<MathematicianFindByMid> findByMid(Long mid) {
        BiFunction<TypeSystem, MapAccessor, Mathematician> mappingFunction = mappingContext.getRequiredMappingFunctionFor(Mathematician.class);
        return client
                .query("""
                        match (advisor:Mathematician{mid:$mid})-[:advisorOf*0..3]->(student:Mathematician)
                        with collect(distinct student.mid) as ids
                        match (advisor:Mathematician)-[d:advisorOf]->(student:Mathematician)
                        where student.mid in ids
                        return advisor,student
                        union
                        match (advisor:Mathematician{mid:$mid})<-[:advisorOf*0..3]-(student:Mathematician)
                        with collect(distinct student.mid) as ids
                        match (advisor:Mathematician)-[d:advisorOf]->(student:Mathematician)
                        where student.mid in ids
                        return advisor,student""")
                .bind(mid).to("mid")
                .fetchAs(MathematicianFindByMid.class)
                .mappedBy((TypeSystem t, Record record) -> {
                    Mathematician advisor = mappingFunction.apply(t,record.get("advisor").asNode());
                    Mathematician student = mappingFunction.apply(t,record.get("student").asNode());
                    return new MathematicianFindByMid(advisor, student);
                }).all();
    }

}
