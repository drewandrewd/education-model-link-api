package phoenixit.education.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import phoenixit.education.models.ClassNode;

import java.util.Optional;

@Repository
public interface ClassRepository extends Neo4jRepository<ClassNode, Long> {

    Optional<ClassNode> findById(Long id);
}
