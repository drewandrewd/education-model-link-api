package phoenixit.education.services;

import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.models.ClassLinkMessage;
import phoenixit.education.models.ClassNode;

public interface ClassNodeService {

    ClassNode fetchByNodeId(Long id) throws ClassNodeNotFoundException;

    Long create(ClassLinkMessage classLinkMessage);

    void update(ClassLinkMessage classLinkMessage) throws ClassNodeNotFoundException;

    void delete(Long id) throws ClassNodeNotFoundException;

}
