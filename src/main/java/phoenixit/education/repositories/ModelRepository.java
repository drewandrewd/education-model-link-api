package phoenixit.education.repositories;

import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import phoenixit.education.models.ModelNode;

import java.util.List;

public interface ModelRepository extends Neo4jRepository<ModelNode, Long> {

    Mono<ModelNode> findOneByTitle(String title);
}
