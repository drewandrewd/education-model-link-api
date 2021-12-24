package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import phoenixit.education.exceptions.NodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

@JsonRpcService("/api/v1/model.json")
public interface Api {

    @PutMapping
    ClassNode create(@JsonRpcParam(value = "classNode") ClassNode classNode);

    @PutMapping
    ClassNode update(@JsonRpcParam(value = "classNode") ClassNode classNode) throws NodeNotFoundException;

    @DeleteMapping("/{id}")
    ClassNode classDelete(@JsonRpcParam(value = "classId") Long id);

    @PutMapping
    ModelNode create(@JsonRpcParam(value = "modelNode") ModelNode modelNode);

    @PutMapping
    ModelNode update(@JsonRpcParam(value = "modelNode") ModelNode modelNode) throws NodeNotFoundException;

    @DeleteMapping("/{id}")
    ModelNode modelDelete(@JsonRpcParam(value = "modelId") Long id);
}
