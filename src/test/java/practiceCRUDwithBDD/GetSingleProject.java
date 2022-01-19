package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleProject {
	
	@Test
	public void getSingleProject() {
		
		when()
		.get("http://localhost:8084/projects/TY_PROJ_006")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
