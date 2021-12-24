package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ModelNode;
import phoenixit.education.repositories.ModelRepository;

import java.util.Optional;


public class ModelNodeServiceImpl implements ModelNodeService {

    private ModelRepository repository;

    @Override
    public ModelNode create(ModelNode modelNode) {
        return repository.save(modelNode);
    }

    @Override
    public ModelNode update(ModelNode modelNode) throws NodeNotFoundException {
        Optional<ModelNode> current = repository.findById(modelNode.getId());
        String newTitle = modelNode.getTitle();
        if (current.isPresent()) {
            ModelNode oldModel = current.get();
            if (!newTitle.equals(oldModel.getTitle())) {
                oldModel.setTitle(newTitle);
            }
            return oldModel;
        } else {
            throw new NodeNotFoundException();
        }
    }

    @Override
    public ModelNode delete(Long id) {
        Optional<ModelNode> modelNode = repository.findById(id);
        repository.delete(modelNode.get());
        return modelNode.get();
    }

    @Autowired
    public void setRepository(ModelRepository repository) {
        this.repository = repository;
    }
}
