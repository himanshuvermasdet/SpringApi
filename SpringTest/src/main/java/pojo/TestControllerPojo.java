package pojo;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class TestControllerPojo {

	String testName = null;
	int testId = 0;
	ArrayList<TestSubControllerPojo> subChilds = null;

	@JsonProperty("SubChilds")
	public ArrayList<TestSubControllerPojo> getSubChilds() {
		return subChilds;
	}

	public void setSubChilds(ArrayList<TestSubControllerPojo> subChilds) {
		this.subChilds = subChilds;
	}

	@JsonProperty("Child-Name")
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@JsonProperty("Child-Id")
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public TestControllerPojo() {

	}

}
