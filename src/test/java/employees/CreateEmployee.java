package employees;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateEmployee {
	
	@Test
	public void addEmployee() {
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("designation", "Software Engineer");
		jsonobj.put("dob", "10/10/1980");
		jsonobj.put("email", "abc@mail.com");
		jsonobj.put("empName", "VijayRamach");
		jsonobj.put("experience", 5);
		jsonobj.put("mobileNo", "1234567890");
		jsonobj.put("project", "SDET");
		jsonobj.put("role", "ROLE_ADMIN");
		jsonobj.put("username", "Vijay");
		
		Response response = given()
			.contentType(ContentType.JSON)
			.body(jsonobj)
			
		.when()
			.post("http://localhost:8084/employees");
		String actualEmpId = response.jsonPath().get("employeeId");
		System.out.println(actualEmpId);
			
		response.then()
			.assertThat()
			.statusCode(201)
			.log().all();
	}

}
