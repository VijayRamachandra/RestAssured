package testScriptsRMGYANTRA;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Project_And_Allocate_User {
	
	@Test
	public void createProjectAllocateUser() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "deepak");
		jsonobj.put("projectName", "Airtel");
		jsonobj.put("status", "Completed");
		jsonobj.put("teamSize", 12);
		
		//Precondition
		Response response = given()
		.contentType(ContentType.JSON)
		.body(jsonobj)
		
		.when()
		.post("http://localhost:8084/addProject");
		String actualProjectName = response.jsonPath().get("projectName");
		
		response.then()
			.assertThat()
			.statusCode(201)
			.log().all();
		
		JSONObject jsonobj1 = new JSONObject();
		jsonobj1.put("designation", "SDET");
		jsonobj1.put("dob", "25/05/1999");
		jsonobj1.put("email", "nithesh@gmail.com");
		jsonobj1.put("empName", "nithesh");
		jsonobj1.put("experience", 15);
		jsonobj1.put("mobileNo","9888777657");
		jsonobj1.put("project", actualProjectName);
		jsonobj1.put("role", "ROLE_ADMIN");
		jsonobj1.put("username", "nithesh");
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonobj1)
			
		.when()
			.post("http://localhost:8084/employees")
			
		.then()
			.assertThat()
			.statusCode(201)
			.log().all();
		
	}

}
