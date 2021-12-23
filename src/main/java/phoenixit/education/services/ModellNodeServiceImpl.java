package phoenixit.education.services;

import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import phoenixit.education.components.Converter;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;
import phoenixit.education.repositories.ModelRepository;

import java.util.concurrent.atomic.AtomicReference;

public class ModellNodeServiceImpl implements ModelNodeService {

    Converter converter;
    ModelRepository repository;

    @Override
    public ModelNode create(ClassNode classNode) {
        ModelNode model = converter.classToModel(classNode);
        model.setId(classNode.getId());
        model.setTitle(classNode.getTitle());
        return model;
    }

    @Override
    public AtomicReference<ModelNode> update(ClassNode classNode) {
        ModelNode model = converter.classToModel(classNode);
        Long modelId = model.getId();
        Mono<ModelNode> current = repository.findOneByTitle(model.getTitle());
        if (!current.equals(Mono.empty())) {
            AtomicReference<ModelNode> newModel = null;
            current.subscribe(x -> {
                newModel.set(x);
            });
            return newModel;
        }
        return null;
    }

    @Override
    public ModelNode delete(Long id) {
        return null;
    }

    @Autowired
    public ModellNodeServiceImpl(Converter converter) {
        this.converter = converter;
    }
}
