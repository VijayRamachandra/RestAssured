package parametersAndAuthentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {
	
	@Test
	public void basicAuthentication() {
		// basic auth
		// method auth() & basic()
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
			.get("http://localhost:8084/login")
		
		.then()
			.assertThat()
			.statusCode(202)
			.log().all();
		
	}

}
