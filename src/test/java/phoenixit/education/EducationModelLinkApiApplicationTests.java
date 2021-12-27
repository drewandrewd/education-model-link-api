package phoenixit.education;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;
import phoenixit.education.services.ClassNodeService;
import phoenixit.education.services.ModelNodeService;
import phoenixit.education.services.ModelNodeServiceImpl;

@Slf4j
@SpringBootTest
class EducationModelLinkApiApplicationTests {

//	private ModelNodeService modelNodeService;
//	private ClassNodeService classNodeService;

	@Test
	void contextLoads() {
	}

	@Test
	void createTest() throws ClassNodeNotFoundException {
		ClassNode classNode = new ClassNode();
		classNode.setId(777L);
		classNode.setTitle("New Title");
		//classNodeService.create(classNode);
		ModelLinkMessage modelLinkMessage = new ModelLinkMessage();
		modelLinkMessage.setModelNodeId(55L);
		modelLinkMessage.setModelNodeTitle("TTT");
		modelLinkMessage.setClassNodeId(classNode.getId());
		//modelNodeService.create(modelLinkMessage);
	}

//	@Autowired
//	public void setModelNodeService(ModelNodeService modelNodeService) {
//		this.modelNodeService = modelNodeService;
//	}
//
//	@Autowired
//	public void setClassNodeService(ClassNodeService classNodeService) {
//		this.classNodeService = classNodeService;
//	}
}
