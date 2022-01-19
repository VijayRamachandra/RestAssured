package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import SDET25_26_POJOClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class RequestChainingPostToDelete {

	@Test
	public void requestChainingPostToDelete() {

		baseURI = "http://localhost";
		port = 8084;
		
		HashMap map = new HashMap();
		map.put("createdBy", "Harsha");
		map.put("projectName", "Goa");
		map.put("status", "Created");
		map.put("teamSize", "2");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body(map)
		
		.when()
			.post("/addProject");
			String projId = response.jsonPath().get("projectId");
			System.out.println(projId);
		
		given()
			.pathParam("projectId", projId)
		
		.when()
			.delete("/projects/{projectId}")
		
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
	}

}
