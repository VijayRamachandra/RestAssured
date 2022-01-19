package testScriptsRMGYANTRA;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseAPIClass;
import com.genericUtils.IpathConstant;
import com.genericUtils.JavaUtility;

import SDET25_26_POJOClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateResource extends BaseAPIClass{
	
	@Test
	public void createResource() throws SQLException {
		//create random number
		int randomNumber = jUtil.getRandomNumber();
		String expectedProjectName = "QuantumOfSolace"+randomNumber;
		ProjectLibrary pojo = new ProjectLibrary("Bond", expectedProjectName, "Completed", 007);
		Response response = given()
			.contentType(ContentType.JSON)
			.body(pojo)
			
		.when()
			.post(IpathConstant.ADD_PROJECT);
		String responseActualProjectName = jsonUtil.getJsonDataValue(response, "projectName");
		
		response.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
		
		//data base value verification
		String query = "select * from project";
		String dbActualProjectName = dbUtil.getAndVerifyTheData(query, 4, expectedProjectName);
		
		//verifications
		Assert.assertEquals(responseActualProjectName, expectedProjectName);
		Assert.assertEquals(dbActualProjectName, expectedProjectName);
	}

}
