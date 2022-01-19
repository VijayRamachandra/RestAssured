package parametersAndAuthentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameters {
	
	@Test
	public void path() {
		
		given()
			.pathParam("projectId", "TY_PROJ_1203")
		
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
	}

}
