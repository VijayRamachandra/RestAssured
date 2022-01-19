package RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class RequestChainingGetToDelete {

	@Test
	public void chaining() {
		//get all projects and delete
		Response response = when()
				.get("http://localhost:8084/projects");
		String proId = response.jsonPath().get("[0].projectId");
		
		given()
			.pathParam("projectId", proId)
		
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();

	}
}
