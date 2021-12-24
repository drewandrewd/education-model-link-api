package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.repositories.ClassRepository;

import java.util.Optional;


public class ClassNodeServiceImpl implements ClassNodeService {

    private ClassRepository repository;

    @Override
    public ClassNode create(ClassNode classNode) {
        return repository.save(classNode);
    }

    @Override
    public ClassNode update(ClassNode classNode) throws NodeNotFoundException {
        Optional<ClassNode> current = repository.findById(classNode.getId());
        String newTitle = classNode.getTitle();
        if (current.isPresent()) {
            ClassNode oldModel = current.get();
            if (!newTitle.equals(oldModel.getTitle())) {
                oldModel.setTitle(newTitle);
            }
            return oldModel;
        } else {
            throw new NodeNotFoundException();
        }
    }

    @Override
    public ClassNode delete(Long id) {
        Optional<ClassNode> classNode = repository.findById(id);
        repository.delete(classNode.get());
        return classNode.get();
    }

    @Autowired
    public void setRepository(ClassRepository repository) {
        this.repository = repository;
    }
}
