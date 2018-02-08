package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.TestControllerPojo;

@Controller
@RequestMapping("/subChild")
public class TestSubController {
	@RequestMapping(/*value = "{name}",*/ method = RequestMethod.GET)
	public @ResponseBody TestControllerPojo getDataInJson(/*@PathVariable String name*/) {

		TestControllerPojo obj = new TestControllerPojo();
		obj.setTestName("child");
		obj.setTestId(1);
		return obj;
	}

}
