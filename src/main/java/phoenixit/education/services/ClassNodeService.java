package phoenixit.education.services;

import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.models.ClassNode;

public interface ClassNodeService {

    ClassNode fetchByNodeId(Long id) throws ClassNodeNotFoundException;

    ClassNode create(ClassNode classNode);

    ClassNode update(ClassNode classNode) throws ClassNodeNotFoundException;

    ClassNode delete(Long id) throws ClassNodeNotFoundException;

}
