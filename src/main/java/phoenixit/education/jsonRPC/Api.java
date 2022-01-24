package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;

import java.util.List;

@JsonRpcService("/api/v1/modelLink.json")
public interface Api {
    //todo clear code
    //todo change get model in create and update for ModelNode

    ClassNode create(@JsonRpcParam(value = "classNode") ClassNode classNode);

    ClassNode update(@JsonRpcParam(value = "classNode") ClassNode classNode) throws ClassNodeNotFoundException;

    ClassNode classDelete(@JsonRpcParam(value = "classId") Long id) throws ClassNodeNotFoundException;

    Long create(@JsonRpcParam(value = "modelLink") ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException;

    void update(@JsonRpcParam(value = "modelLink") ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException;

    void modelDelete(@JsonRpcParam(value = "modelId") Long id) throws ModelNodeNotFoundException;

    ClassNode fetchByClassNodeId(@JsonRpcParam(value = "classId") Long id) throws ClassNodeNotFoundException;

    ModelNode fetchByModelNodeId(@JsonRpcParam(value = "modelId") Long id) throws ModelNodeNotFoundException;

    List<Long> fetchModelsByClassNodeId(@JsonRpcParam(value = "classId") Long id) throws ClassNodeNotFoundException;
}
