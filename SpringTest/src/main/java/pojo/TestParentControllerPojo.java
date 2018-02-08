package pojo;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class TestParentControllerPojo {

	public String testName = null;
	public int testId = 0;
	ArrayList<TestControllerPojo> childs = null;

	@JsonProperty("Childs")
	public ArrayList<TestControllerPojo> getTestControllerobj() {
		return childs;
	}

	public void setTestControllerobj(ArrayList<TestControllerPojo> testControllerobj) {
		this.childs = testControllerobj;
	}

	@JsonProperty("Parent-Name")
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@JsonProperty("Parent-Id")
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public TestParentControllerPojo() {

	}

}
