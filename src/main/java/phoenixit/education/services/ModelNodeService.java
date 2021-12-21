package phoenixit.education.services;

import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

public interface ModelNodeService {

    ModelNode create(ClassNode classNode);

    ModelNode update(ClassNode modelRequest);

    ModelNode delete(Long id);
}
