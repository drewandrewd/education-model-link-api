package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;
import phoenixit.education.repositories.ClassRepository;
import phoenixit.education.repositories.ModelRepository;

import java.util.Optional;

@Service
public class ModelNodeServiceImpl implements ModelNodeService {

    private ModelRepository modelRepository;
    private ClassRepository classRepository;

    @Override
    public ModelNode findById(ModelLinkMessage modelLinkMessage) {
        return null;
    }

    @Override
    public ModelNode create(ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException {
        //todo add model: ModelLinkMessage(Long modelNodeId, String modelTitle, Long classNodeId)
        //todo find classNode by classNodeId -> set classnode to modelnode and save
        Optional<ClassNode> classNode = classRepository.findById(modelLinkMessage.getClassNodeId());
        if (classNode.isPresent()) {
            ModelNode modelNode = new ModelNode();
            modelNode.setTitle(modelLinkMessage.getModelNodeTitle());
            modelNode.setClassNode(classNode.get());
            return modelRepository.save(modelNode);
        } else {
            throw new ClassNodeNotFoundException();
        }
    }

    @Override
    public ModelNode update(ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException {
        //todo get model: ModelLinkMessage(Long modelNodeId, String modelTitle, Long classNodeId)
        Optional<ModelNode> current = modelRepository.findById(modelLinkMessage.getModelNodeId());
        String newTitle = modelLinkMessage.getModelNodeTitle();
        Long newClassNodeId = modelLinkMessage.getClassNodeId();
        //todo find classNode by classNodeId, check and compare with old value -> change if it different
        if (current.isPresent()) {
            //todo classNode.isPresent check
            ModelNode oldModel = current.get();
            Optional<ClassNode> newClassNode = classRepository.findById(newClassNodeId);
            if (!newTitle.equals(oldModel.getTitle())) {
                oldModel.setTitle(newTitle);
            }
            if (newClassNode.isPresent()) {
                if (newClassNodeId != oldModel.getClassNode().getId()) {
                    oldModel.setClassNode(newClassNode.get());
                }
            } else {
                throw new ClassNodeNotFoundException();
            }
            return modelRepository.save(oldModel);
        } else {
            throw new ModelNodeNotFoundException();
        }
    }

    @Override
    public ModelNode delete(Long id) throws ModelNodeNotFoundException {
        Optional<ModelNode> modelNode = modelRepository.findById(id);
        modelRepository.delete(modelNode.orElseThrow(ModelNodeNotFoundException::new));
        return modelNode.get();
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setClassRepository(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
}
