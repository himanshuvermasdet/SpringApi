package pojo;

import org.codehaus.jackson.annotate.JsonProperty;

public class TestSubControllerPojo {

	String testName=null;
	int testId = 0;	
	
	@JsonProperty("SubChild-Name")
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	@JsonProperty("SubChild-Id")
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public TestSubControllerPojo(){
		
	}

}
