package RequestChaining;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class RequestChainingPostToPut {
	
	@Test
	public void postToPut() {
		
		baseURI = "http://localhost";
		port=8084;
		
		//create a project
		HashMap map = new HashMap();
		map.put("createdBy", "Mr. Vijay");
		map.put("projectName", "Target");
		map.put("status", "On going");
		map.put("teamSize", 10);
		
		Response response = given()
			.contentType(ContentType.JSON)
			.body(map)
			
		.when()
			.post("/addProject");
			String actualProjectId = response.jsonPath().get("projectId");
			String initialName = response.jsonPath().get("createdBy");
			System.out.println(actualProjectId);
			System.out.println(initialName);
		
			HashMap map1 = new HashMap();
			map1.put("createdBy", "Mr. HariKishan");
			map1.put("projectName", "Target");
			map1.put("status", "On going");
			map1.put("teamSize", 10);
			
		Response response1 = given()
			.contentType(ContentType.JSON)
			.body(map1)
			.pathParam("projectId", actualProjectId)
			
		.when()
			.put("/projects/{projectId}");
			String finalName = response1.jsonPath().get("createdBy");
			System.out.println(finalName);
			
		response1.then()
			.assertThat()
			.log().all();
			
	
	}

}
