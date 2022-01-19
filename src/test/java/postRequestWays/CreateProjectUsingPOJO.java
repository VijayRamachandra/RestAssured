package postRequestWays;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import SDET25_26_POJOClass.ProjectLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingPOJO {
	
	@Test
	public void createProjectUsingPOJO() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary pLib = new ProjectLibrary("VijayRama", "Moon", "On going", 30);
		
		given()
			.contentType(ContentType.JSON)
			.body(pLib)
		
		.when()
			.post("/addProject")
		
		.then()
			.assertThat()
			.statusCode(201)
			.log().all();
	}

}
