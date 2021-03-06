package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ClassLinkMessage;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;
import phoenixit.education.services.ClassNodeService;
import phoenixit.education.services.ModelNodeService;

import java.util.List;

@Service
@AutoJsonRpcServiceImpl
public class ApiImpl implements Api{

    private ModelNodeService modelNodeService;
    private ClassNodeService classNodeService;

    @Override
    public Long classCreate(ClassLinkMessage classLinkMessage) {
        return classNodeService.create(classLinkMessage);
    }

    @Override
    public void classUpdate(ClassLinkMessage classLinkMessage) throws ClassNodeNotFoundException {
        classNodeService.update(classLinkMessage);
    }

    @Override
    public void classDelete(Long id) throws ClassNodeNotFoundException {
        classNodeService.delete(id);
    }

    @Override
    public Long create(ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException {
        return modelNodeService.create(modelLinkMessage);
    }

    @Override
    public void update(ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException {
        modelNodeService.update(modelLinkMessage);
    }

    @Override
    public void modelDelete(Long id) throws ModelNodeNotFoundException {
        modelNodeService.delete(id);
    }

    @Override
    public ClassNode fetchByClassNodeId(Long id) throws ClassNodeNotFoundException {
        return classNodeService.fetchByNodeId(id);
    }

    @Override
    public ModelNode fetchByModelNodeId(Long id) throws ModelNodeNotFoundException {
        return modelNodeService.fetchByNodeId(id);
    }

    @Override
    public List<Long> fetchModelsByClassNodeId(Long id) throws ClassNodeNotFoundException {
        return modelNodeService.fetchModelsByClassNodeId(id);
    }

    @Autowired
    public void setModelNodeService(ModelNodeService modelNodeService) {
        this.modelNodeService = modelNodeService;
    }

    @Autowired
    public void setClassNodeService(ClassNodeService classNodeService) {
        this.classNodeService = classNodeService;
    }
}
