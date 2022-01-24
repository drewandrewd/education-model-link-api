package phoenixit.education.services;

import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;

import java.util.List;

public interface  ModelNodeService {

    ModelNode fetchByNodeId(Long modelNodeId) throws ModelNodeNotFoundException;

    Long create(ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException;

    void update(ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException;

    void delete(Long id) throws ModelNodeNotFoundException;

    List<Long> fetchModelsByClassNodeId(Long classNodeId) throws ClassNodeNotFoundException;

}
