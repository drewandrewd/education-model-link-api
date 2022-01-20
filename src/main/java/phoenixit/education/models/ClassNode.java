package phoenixit.education.models;

import com.fasterxml.jackson.databind.type.ClassKey;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Class")
@Data
public class ClassNode {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
}
