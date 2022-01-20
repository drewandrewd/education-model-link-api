package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.repositories.ClassRepository;

import java.util.Optional;

@Service
public class ClassNodeServiceImpl implements ClassNodeService {

    private ClassRepository repository;

    //todo findById
    @Override
    public ClassNode findById(Long id) throws ClassNodeNotFoundException {
        Optional<ClassNode> classNode = repository.findById(id);
        if (classNode.isPresent()) {
            return repository.save(classNode.get());
        } else {
            throw new ClassNodeNotFoundException();
        }
    }

    @Override
    public ClassNode create(ClassNode classNode) {
        return repository.save(classNode);
    }

    @Override
    public ClassNode update(ClassNode classNode) throws ClassNodeNotFoundException {
        Optional<ClassNode> current = repository.findById(classNode.getId());
        String newTitle = classNode.getTitle();
        if (current.isPresent()) {
            ClassNode oldModel = current.get();
            if (!newTitle.equals(oldModel.getTitle())) {
                oldModel.setTitle(newTitle);
            }
            return repository.save(oldModel);
        } else {
            throw new ClassNodeNotFoundException();
        }
    }
    //
    @Override
    public ClassNode delete(Long id) throws ClassNodeNotFoundException {
        Optional<ClassNode> classNode = repository.findById(id);
        //todo classNode.isPresent check
        if (classNode.isPresent()) {
            repository.delete(classNode.get());
            return classNode.get();
        } else {
            throw new ClassNodeNotFoundException();
        }
    }

    @Override
    public boolean fetchByNodeId(Long id) {
        boolean result = true;
        try {
            ClassNode classNode = repository.findById(id).get();
        } catch (Exception e) {
            result = false;
        } finally {
            return result;
        }
    }

    @Autowired
    public void setRepository(ClassRepository repository) {
        this.repository = repository;
    }
}
