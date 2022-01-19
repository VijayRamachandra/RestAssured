package parametersAndAuthentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParameterUsingGitApi {
	
	@Test
	public void parameterUsingGit() {
		
		given()
			.pathParam("username", "asdm96")
			.queryParam("sort", "created")
		
		.when()
			.get("https://api.github.com/users/{username}/repos")
		
		.then()
			.assertThat()
			.log().all();
	}

}
