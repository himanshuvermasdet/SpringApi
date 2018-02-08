package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pojo.TestParentControllerPojo;

public class CategoryDaoRowMapper implements RowMapper {

	public TestParentControllerPojo mapRow(ResultSet rs, int rowNum) throws SQLException {

		TestParentControllerPojo parentObj = new TestParentControllerPojo();
		parentObj.setTestName(rs.getString("catName"));
		parentObj.setTestId(Integer.parseInt(rs.getString("catId")));
		//System.out.println(parentObj.getTestName() + " :: " + parentObj.getTestId());
		return parentObj;
	}

}