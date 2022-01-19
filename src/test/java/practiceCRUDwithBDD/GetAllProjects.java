package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	
	@Test
	public void getAllProjects() {
		
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
