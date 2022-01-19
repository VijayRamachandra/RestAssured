package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticResponseValidation() {

		String expectedProjectName = "students";
		Response response = when()
				.get("http://localhost:8084/projects");
		String actualProjectName = response.jsonPath().get("[0].projectName");
		response.then()
					.assertThat()
					.statusCode(200)
					.contentType(ContentType.JSON)
					.log().all();

		Assert.assertEquals(actualProjectName, expectedProjectName);
	}

}
