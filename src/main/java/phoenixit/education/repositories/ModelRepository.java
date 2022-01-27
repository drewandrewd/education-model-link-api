package phoenixit.education.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends Neo4jRepository<ModelNode, Long> {

    Optional<ModelNode> findById(Long id);

    @Query("MATCH (n:Class)<-[:CLASS]-(m:Model) WHERE id(n) = $classNodeId RETURN id(m)")
    List<Long> findByClassNode(Long classNodeId);

    @Query("MATCH (m:Model), (c:Class) WHERE id(m) = $modelNodeId AND id(c) = $classNodeId CREATE (m)-[:CLASS]->(c)")
    void makeRelations(Long modelNodeId, Long classNodeId);
}
