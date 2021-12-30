package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;

@JsonRpcService("/api/v1/modelLink.json")
public interface Api {
    //todo clear code
    //todo change get model in create and update for ModelNode

    ClassNode create(@JsonRpcParam(value = "classNode") ClassNode classNode);

    ClassNode update(@JsonRpcParam(value = "classNode") ClassNode classNode) throws ClassNodeNotFoundException;

    ClassNode classDelete(@JsonRpcParam(value = "classId") Long id) throws ClassNodeNotFoundException;

    ModelNode create(@JsonRpcParam(value = "modelLink") ModelLinkMessage modelLinkMessage) throws ClassNodeNotFoundException;

    ModelNode update(@JsonRpcParam(value = "modelLink") ModelLinkMessage modelLinkMessage) throws ModelNodeNotFoundException, ClassNodeNotFoundException;

    ModelNode modelDelete(@JsonRpcParam(value = "modelId") Long id) throws ModelNodeNotFoundException;
}
