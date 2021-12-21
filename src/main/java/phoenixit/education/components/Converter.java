package phoenixit.education.components;

import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

public class Converter {

    public ModelNode classToModel(ClassNode classNode) {
        ModelNode model = new ModelNode();
        model.setId(classNode.getId());
        model.setTitle(classNode.getTitle());;
        return model;
    }
}
