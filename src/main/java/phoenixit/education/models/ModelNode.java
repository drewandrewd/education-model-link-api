package phoenixit.education.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@Node("Model")
public class ModelNode {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @Relationship(type = "CLASS")
    private ClassNode classNode;
}
