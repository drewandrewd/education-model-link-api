package phoenixit.education.services;

import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ClassNode;

public interface ClassNodeService {

    ClassNode create(ClassNode classNode);

    ClassNode update(ClassNode classNode) throws NodeNotFoundException;

    ClassNode delete(Long id);
}
