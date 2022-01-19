package employees;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingCreateAndDeleteUser {
	
	@Test
	public void createAndDeleteUser() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("designation", "SDET");
		jsonobj.put("dob", "25/05/1999");
		jsonobj.put("email", "paven@gmail.com");
		jsonobj.put("empName", "nithesh");
		jsonobj.put("experience", 15);
		jsonobj.put("mobileNo", "9888777657");
		jsonobj.put("project", "pavan");
		jsonobj.put("role", "ROLE_ADMIN");
		jsonobj.put("username", "pavan");
		
		Response response = given()
			.contentType(ContentType.JSON)
			.body(jsonobj)
			
		.when()
			.post("http://localhost:8084/employees");
		String employeId = response.jsonPath().get("employeeId");
		
		response.then()
			.assertThat()
			.statusCode(201)
			.log().all();
		
		given()
			.pathParam("empId", employeId)
			
		.when()
			.delete("http://localhost:8084/employees/{empId}")
			
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
			
	}

}
