package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	public void dynamicResponseValidation() {
		String expectedProjectName = "students";
		Response response = when()
				.get("http://localhost:8084/projects");
		List<String> proName = response.jsonPath().get("projectName");
		//boolean flag = false;
		String actualProjectName = null;
		for (String  element : proName) {
			if(element.equals(expectedProjectName)) {
				actualProjectName=element;
				//flag=true;
				break;
			}
		}
		response.then()
					.assertThat()
					.statusCode(200)
					.contentType(ContentType.JSON)
					.log().all();

		Assert.assertEquals(expectedProjectName, actualProjectName);
		//Assert.assertEquals(flag, true);


	}

}
