package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.models.ClassLinkMessage;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;
import phoenixit.education.repositories.ClassRepository;

import java.util.Optional;

@Service
public class ClassNodeServiceImpl implements ClassNodeService {

    private ClassRepository repository;

    @Override
    public ClassNode fetchByNodeId(Long id) throws ClassNodeNotFoundException {
        Optional<ClassNode> classNode = repository.findById(id);
        if (classNode.isPresent()) {
            return classNode.get();
        } else {
            throw new ClassNodeNotFoundException();
        }
    }

    @Override
    public Long create(ClassLinkMessage classLinkMessage) {
        ClassNode classNode = new ClassNode();
        classNode.setTitle(classLinkMessage.getClassNodeTitle());
        repository.save(classNode);
        return classNode.getId();
    }

    @Override
    public void update(ClassLinkMessage classLinkMessage) throws ClassNodeNotFoundException {
        Optional<ClassNode> current = repository.findById(classLinkMessage.getClassNodeId());
        String newTitle = classLinkMessage.getClassNodeTitle();
        if (current.isPresent()) {
            ClassNode oldModel = current.get();
            if (!newTitle.equals(oldModel.getTitle())) {
                oldModel.setTitle(newTitle);
            }
            repository.save(oldModel);
        } else {
            throw new ClassNodeNotFoundException();
        }
    }

    @Override
    public void delete(Long id) throws ClassNodeNotFoundException {
        Optional<ClassNode> classNode = repository.findById(id);
        if (classNode.isPresent()) {
            repository.delete(classNode.get());
        } else {
            throw new ClassNodeNotFoundException();
        }
    }

    @Autowired
    public void setRepository(ClassRepository repository) {
        this.repository = repository;
    }
}
