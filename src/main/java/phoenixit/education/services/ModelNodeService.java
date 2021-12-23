package phoenixit.education.services;

import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ModelNode;


public interface ModelNodeService {

    ModelNode create(ModelNode modelNode);

    ModelNode update(ModelNode modelNode) throws NodeNotFoundException;

    ModelNode delete(Long id);
}
