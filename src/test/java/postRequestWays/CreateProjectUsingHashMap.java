package postRequestWays;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMap {
	
	@Test
	public void createProjectUsingHashMap() {
	
		baseURI = "http://localhost";
		port = 8084;
		
		HashMap map = new HashMap();
		map.put("createdBy", "Kan");
		map.put("projectName", "Zoldon");
		map.put("status", "Created");
		map.put("teamSize", "25");
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		
		.when()
			.post("/addProject")
		
		.then()
			.assertThat()
			.statusCode(201)
			.log().all();
	}

}
