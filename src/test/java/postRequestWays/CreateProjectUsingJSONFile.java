package postRequestWays;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONFile {
	
	@Test
	public void createProjectUsingJSONFile() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		//prepare the request body
		File fis = new File("./data.json");
		
		given()
			.contentType(ContentType.JSON)
			.body(fis)
		
		.when()
			.post("/addProject")
		
		.then()
			.assertThat()
			.statusCode(201)
			.log().all();
	}

}
