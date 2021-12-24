package phoenixit.education.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;

@Configuration
@EnableReactiveNeo4jRepositories
public class Neo4jConfig {
}
