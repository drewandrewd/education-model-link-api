package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;
import phoenixit.education.services.ClassNodeService;
import phoenixit.education.services.ModelNodeService;

@Service
@AutoJsonRpcServiceImpl
public class ApiImpl implements Api{

    private ModelNodeService modelNodeService;
    private ClassNodeService classNodeService;

    @Override
    public ClassNode create(ClassNode classNode) {
        return classNodeService.create(classNode);
    }

    @Override
    public ClassNode update(ClassNode classNode) throws ClassNodeNotFoundException {
        return classNodeService.update(classNode);
    }

    @Override
    public ClassNode classDelete(Long id) throws ClassNodeNotFoundException {
        return classNodeService.delete(id);
    }

    @Override
    public ModelNode create(ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException {
        return modelNodeService.create(modelLinkMessage);
    }

    @Override
    public ModelNode update(ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException {
        return modelNodeService.update(modelLinkMessage);
    }

    @Override
    public ModelNode modelDelete(Long id) throws ModelNodeNotFoundException {
        return modelNodeService.delete(id);
    }

    @Autowired
    public ModelNodeService setModelNodeService() {
        return modelNodeService;
    }

    @Autowired
    public ClassNodeService setClassNodeService() {
        return classNodeService;
    }
}
