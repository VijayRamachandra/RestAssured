package parametersAndAuthentications;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {

	@Test
	public void bearerTokenAuth() {
		// basic auth
		// method auth() & oauth2()
		given()
			.auth()
			.oauth2("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")
			
		.when()
			.get("https://api.github.com/user/repos")

		.then()
			.assertThat()
			.statusCode(200)
			.log().all();
	}

}
