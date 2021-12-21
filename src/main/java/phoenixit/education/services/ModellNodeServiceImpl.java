package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import phoenixit.education.components.Converter;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;
import phoenixit.education.repositories.ModelRepository;

public class ModellNodeServiceImpl implements ModelNodeService {

    Converter converter;
    ModelRepository repository;

    @Override
    public ModelNode create(ClassNode classNode) {
        return converter.classToModel(classNode);
    }

    @Override
    public ModelNode update(ClassNode modelRequest) {
        return converter.classToModel(modelRequest);
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
