package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ClassNode;
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
    public ClassNode update(ClassNode classNode) throws NodeNotFoundException {
        return classNodeService.update(classNode);
    }

    @Override
    public ClassNode classDelete(Long id) {
        return classNodeService.delete(id);
    }

    @Override
    public ModelNode create(ModelNode modelNode) {
        return modelNodeService.create(modelNode);
    }

    @Override
    public ModelNode update(ModelNode modelNode) throws NodeNotFoundException {
        return modelNodeService.update(modelNode);
    }

    @Override
    public ModelNode modelDelete(Long id) {
        return modelNodeService.delete(id);
    }

    @Autowired
    public ModelNodeService getModelNodeService() {
        return modelNodeService;
    }

    @Autowired
    public ClassNodeService getClassNodeService() {
        return classNodeService;
    }
}
