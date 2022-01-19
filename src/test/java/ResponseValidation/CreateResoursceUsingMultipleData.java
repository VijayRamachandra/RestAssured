package ResponseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SDET25_26_POJOClass.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResoursceUsingMultipleData {

	@Test(dataProvider = "getData")
	public void create(String createdby, String projectName, String status, int teamSize ) {
		
		ProjectLibrary pojo = new ProjectLibrary(createdby, projectName, status, teamSize);

		given()
			.contentType(ContentType.JSON)
			.body(pojo)

		.when()
			.post("http://localhost:8084/addProject")

		.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();

	}
	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object [2][4];
		obj[0][0] = "Adarsh";
		obj[0][1] = "Byjus";	
		obj[0][2] = "Completed";
		obj[0][3] = 430;	
		
		obj[1][0] = "Chaitra";
		obj[1][1] = "Tech Mahindra";	
		obj[1][2] = "Completed";
		obj[1][3] = 4000;
		return obj;
	}

}
