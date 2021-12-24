package phoenixit.education;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

@SpringBootTest
class EducationModelLinkApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void createTest() {
		ClassNode classNode = new ClassNode();
		classNode.setId(777L);
		classNode.setTitle("New Title");
		ModelNode modelNode = new ModelNode();
		modelNode.setId(55L);
		modelNode.setTitle("Old Title");
		modelNode.setClassNode(classNode);
	}

}
