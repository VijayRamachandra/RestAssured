package employees;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingPostToDelete {

	@Test
	public void postToDelete() {
		JSONObject jsonobj = new JSONObject();

		jsonobj.put("designation", "Software Engineer");
		jsonobj.put("dob", "10/10/1980");
		jsonobj.put("email", "abc@mail.com");
		jsonobj.put("empName", "Neeraj");
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
		String employId = response.jsonPath().get("employeeId");
		System.out.println(employId);

		given()
		.pathParam("empId", employId)

		.when()
		.delete("http://localhost:8084/employees/{empId}")

		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}


