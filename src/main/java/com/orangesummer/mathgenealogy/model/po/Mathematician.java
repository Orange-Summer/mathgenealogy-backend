package com.orangesummer.mathgenealogy.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */

@Data
@AllArgsConstructor
@Node("Mathematician")
public class Mathematician {
    @Id
    private final Long mid;
    @Property("name")
    private final String name;
    @Property("country")
    private final String country;
    @Property("title")
    private final String title;
    @Property("year")
    private final Integer year;
    @Property("institution")
    private final String institution;
    @Property("dissertation")
    private final String dissertation;
    @Property("classification")
    private final Integer classification;
    @Relationship(type = "advisorOf", direction = Relationship.Direction.OUTGOING)
    private List<Mathematician> students = new ArrayList<>();
    @Relationship(type = "studentOf", direction = Relationship.Direction.INCOMING)
    private List<Mathematician> advisors = new ArrayList<>();

}
