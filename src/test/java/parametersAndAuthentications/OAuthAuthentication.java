package parametersAndAuthentications;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuthAuthentication {
	
	@Test
	public void oauthAuthentication() {
		
		Response response = given()
				.formParam("client_id", "SDET25")
				.formParam("client_secret", "fedd20dee886dcf6444a344958d5bee4")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
		
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
			String token = response.jsonPath().get("access_token");
			System.out.println(token);
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "2702")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		.then()
			.log().all();
	}

}
