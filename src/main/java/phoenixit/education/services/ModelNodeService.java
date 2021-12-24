package phoenixit.education.services;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ModelNode;


public interface ModelNodeService {

    ModelNode create(ModelNode modelNode);

    ModelNode update(ModelNode modelNode) throws NodeNotFoundException;

    ModelNode delete(Long id) throws NodeNotFoundException;
}
