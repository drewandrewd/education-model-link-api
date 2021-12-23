package phoenixit.education.services;

import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

import java.util.concurrent.atomic.AtomicReference;

public interface ModelNodeService {

    ModelNode create(ClassNode classNode);

    AtomicReference<ModelNode> update(ClassNode modelRequest);

    ModelNode delete(Long id);
}
