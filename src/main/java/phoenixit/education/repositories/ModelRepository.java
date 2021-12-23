package phoenixit.education.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import phoenixit.education.models.ModelNode;

import java.util.Optional;

public interface ModelRepository extends Neo4jRepository<ModelNode, Long> {

    Optional<ModelNode> findById(Long id);
}
