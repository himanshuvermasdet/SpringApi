package dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import dao.mapper.CategoryDaoRowMapper;
import dao.mapper.SubCategoryDaoRowMapper;
import dao.mapper.SubSubCategoryDaoRowMapper;
import pojo.TestControllerPojo;
import pojo.TestParentControllerPojo;
import pojo.TestSubControllerPojo;

public class CategoryDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	public TestParentControllerPojo getCategoryDetails(String name) {
		String sql = "SELECT categoryName catName, categoryId catId FROM test.category WHERE categoryName=?";
		TestParentControllerPojo parentControllerObj = null;
		try {
			parentControllerObj = (TestParentControllerPojo) getJdbcTemplate().queryForObject(sql,
					new Object[] { name }, new CategoryDaoRowMapper());
		} catch (Exception e) {
			System.out.println("No entry for: " + name);
		}
		return parentControllerObj;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TestControllerPojo> getSubCategoryDetails(int catId) {
		String sql = "SELECT subCategoryName subCatName, subCategoryId subCatId FROM test.subcategory WHERE categoryId=?";
		ArrayList<TestControllerPojo> controllerObj = (ArrayList<TestControllerPojo>) getJdbcTemplate().query(sql,
				new Object[] { catId }, new SubCategoryDaoRowMapper());
		return controllerObj;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TestSubControllerPojo> getSubSubCategoryDetails(int catId, int subCatId) {
		String sql = "SELECT subSubCategoryName subSubCatName, subSubCategoryId subSubCatId FROM test.subsubcategory WHERE categoryId=? and subCategoryId=?";
		ArrayList<TestSubControllerPojo> subControllerObj = (ArrayList<TestSubControllerPojo>) getJdbcTemplate()
				.query(sql, new Object[] { catId, subCatId }, new SubSubCategoryDaoRowMapper());
		return subControllerObj;
	}

}
