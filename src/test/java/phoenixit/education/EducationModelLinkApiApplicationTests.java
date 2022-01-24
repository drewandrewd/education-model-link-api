package phoenixit.education;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import phoenixit.education.exceptions.ClassNodeNotFoundException;
import phoenixit.education.exceptions.ModelNodeNotFoundException;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelLinkMessage;
import phoenixit.education.models.ModelNode;
import phoenixit.education.services.ClassNodeService;
import phoenixit.education.services.ModelNodeService;
import phoenixit.education.services.ModelNodeServiceImpl;

import java.util.List;

@Slf4j
@SpringBootTest
class EducationModelLinkApiApplicationTests {

	private ModelNodeService modelNodeService;
	private ClassNodeService classNodeService;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createTest() throws ClassNodeNotFoundException {
//		ClassNode classNode = new ClassNode();
//		classNode.setId(777L);
//		classNode.setTitle("New Title");
//		//classNodeService.create(classNode);
//		ModelLinkMessage modelLinkMessage = new ModelLinkMessage();
//		modelLinkMessage.setModelNodeId(55L);
//		modelLinkMessage.setModelNodeTitle("TTT");
//		modelLinkMessage.setClassNodeId(classNode.getId());
//		//modelNodeService.create(modelLinkMessage);
//	}
	@Test
	void fetchModelsByClassNodeIdTest() throws ClassNodeNotFoundException {
		List<Long> list = modelNodeService.fetchModelsByClassNodeId(84354L);
		for (Long id : list) {
			System.out.println(id);
		}
	}

	@Test
	void fetchByClassNodeId() throws ClassNodeNotFoundException {
		System.out.println(classNodeService.fetchByNodeId(84354L));
	}

	@Test
	void fetchByModelNodeId() throws ModelNodeNotFoundException {
		System.out.println(modelNodeService.fetchByNodeId(84529L));
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
