package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;
import phoenixit.education.repositories.ModelRepository;

import java.util.Optional;


public class ModelNodeServiceImpl implements ModelNodeService {

    private ModelRepository repository;

    //todo findById

    @Override
    public ModelNode create(ModelNode modelNode) {
        //todo add model: ModelLinkMessage(Long modelNodeId, String modelTitle, Long classNodeId)
        //todo find classNode by classNodeId -> set classnode to modelnode and save
        return repository.save(modelNode);
    }

    @Override
    public ModelNode update(ModelNode modelNode) throws NodeNotFoundException {
        //todo get model: ModelLinkMessage(Long modelNodeId, String modelTitle, Long classNodeId)
        Optional<ModelNode> current = repository.findById(modelNode.getId());
        String newTitle = modelNode.getTitle();
        //todo find classNode by classNodeId, check and compare with old value -> change if it different
        ClassNode newClassNode = modelNode.getClassNode();
        if (current.isPresent()) {
            //todo classNode.isPresent check
            ModelNode oldModel = current.get();
            if (!newTitle.equals(oldModel.getTitle())) {
                oldModel.setTitle(newTitle);
            }
            if (!newClassNode.equals(oldModel.getClassNode())) {
                oldModel.setClassNode(newClassNode);
            }
            return oldModel;
        } else {
            throw new NodeNotFoundException();
        }
    }

    @Override
    public ModelNode delete(Long id) throws NodeNotFoundException {
        Optional<ModelNode> modelNode = repository.findById(id);
        repository.delete(modelNode.orElseThrow(NodeNotFoundException::new));
        return modelNode.get();
    }

    @Autowired
    public void setRepository(ModelRepository repository) {
        this.repository = repository;
    }
}
