package phoenixit.education.services;

import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;

public interface ModelNodeService {

    ModelNode findById(ModelLinkMessage modelLinkMessage);

    ModelNode create(ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException;

    ModelNode update(ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException;

    ModelNode delete(Long id) throws ModelNodeNotFoundException;
}
