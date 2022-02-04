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

import java.util.List;
import java.util.Optional;

@Service
public class ModelNodeServiceImpl implements ModelNodeService {

    private ModelRepository modelRepository;
    private ClassRepository classRepository;

    @Override
    public ModelNode fetchByNodeId(Long modelNodeId) throws ModelNodeNotFoundException {
        Optional<ModelNode> model = modelRepository.findById(modelNodeId);
        if (model.isPresent()) {
            ModelNode modelNode = model.get();
            return modelNode;
        } else {
            throw new ModelNodeNotFoundException();
        }
    }

    @Override
    public Long create(ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException {
        Optional<ClassNode> classNode = classRepository.findById(modelLinkMessage.getClassNodeId());
        if (classNode.isPresent()) {
            ModelNode modelNode = new ModelNode();
            modelNode.setTitle(modelLinkMessage.getModelNodeTitle());
            modelRepository.save(modelNode);
            modelRepository.makeRelations(modelNode.getId(), modelLinkMessage.getClassNodeId());
            return modelNode.getId();
        } else {
            throw new ClassNodeNotFoundException();
        }
    }


    @Override
    public void update(ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException {
        Optional<ModelNode> current = modelRepository.findById(modelLinkMessage.getModelNodeId());
        String newTitle = modelLinkMessage.getModelNodeTitle();
        Long newClassNodeId = modelLinkMessage.getClassNodeId();
        if (current.isPresent()) {
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
            modelRepository.save(oldModel);
        } else {
            throw new ModelNodeNotFoundException();
        }
    }

    @Override
    public void delete(Long id) throws ModelNodeNotFoundException {
        Optional<ModelNode> modelNode = modelRepository.findById(id);
        modelRepository.delete(modelNode.orElseThrow(ModelNodeNotFoundException::new));
    }

    @Override
    public List<Long> fetchModelsByClassNodeId(Long classNodeId) throws ClassNodeNotFoundException {
        Optional<ClassNode> current = classRepository.findById(classNodeId);
        if(current.isPresent()) {
            List<Long> modelNodeIds = modelRepository.findByClassNode(classNodeId);
            return modelNodeIds;
        } else {
            throw new ClassNodeNotFoundException();
        }
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
