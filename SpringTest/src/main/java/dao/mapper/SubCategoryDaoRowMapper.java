package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import pojo.TestControllerPojo;
import pojo.TestParentControllerPojo;

public class SubCategoryDaoRowMapper implements RowMapper {

	public TestControllerPojo mapRow(ResultSet rs, int rowNum) throws SQLException {

		TestControllerPojo subObj = new TestControllerPojo();
		subObj.setTestName(rs.getString("subCatName"));
		subObj.setTestId(Integer.parseInt(rs.getString("subCatId")));
		//System.out.println(subObj.getTestName() + " :: " + subObj.getTestId());
		return subObj;
	}

}