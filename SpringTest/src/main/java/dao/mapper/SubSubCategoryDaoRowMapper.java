package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pojo.TestParentControllerPojo;
import pojo.TestSubControllerPojo;

public class SubSubCategoryDaoRowMapper implements RowMapper {

	public TestSubControllerPojo mapRow(ResultSet rs, int rowNum) throws SQLException {

		TestSubControllerPojo subSubObj = new TestSubControllerPojo();
		subSubObj.setTestName(rs.getString("subSubCatName"));
		subSubObj.setTestId(Integer.parseInt(rs.getString("subSubCatId")));
		//System.out.println(subSubObj.getTestName() + " :: " + subSubObj.getTestId());
		return subSubObj;
	}

}