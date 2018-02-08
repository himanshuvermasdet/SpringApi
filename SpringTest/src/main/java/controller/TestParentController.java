package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import dao.CategoryDao;
import pojo.TestControllerPojo;
import pojo.TestParentControllerPojo;
import pojo.TestSubControllerPojo;

@Controller
@RequestMapping("/parent")
public class TestParentController {

	TestParentControllerPojo testParentControllerObj;
	String json="[]";

	@Autowired
	CategoryDao catDaoObj;

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody String getDataInJson(@PathVariable String name)
			throws JsonGenerationException, JsonMappingException, IOException {

		testParentControllerObj = (TestParentControllerPojo) catDaoObj.getCategoryDetails(name);
		if(testParentControllerObj==null){
			return json;
		}

		ArrayList<TestControllerPojo> testControllerObj = (ArrayList<TestControllerPojo>) catDaoObj
				.getSubCategoryDetails(testParentControllerObj.getTestId());

		Iterator<TestControllerPojo> iter = testControllerObj.iterator();
		while (iter.hasNext()) {
			TestControllerPojo obj = iter.next();
			System.out.println(obj.getTestName() + " :: " + obj.getTestId());
			ArrayList<TestSubControllerPojo> testSubControllerObj = (ArrayList<TestSubControllerPojo>) catDaoObj
					.getSubSubCategoryDetails(testParentControllerObj.getTestId(), obj.getTestId());
			obj.setSubChilds(testSubControllerObj);
		}
		testParentControllerObj.setTestControllerobj(testControllerObj);

		ObjectMapper objectMapper = new ObjectMapper();
		json = objectMapper.writeValueAsString(testParentControllerObj);
		return json;
	}

}
