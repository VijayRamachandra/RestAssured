package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	
	@Test
	public void createProject() {
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "Bajja");
		jsonobj.put("projectName", "SDET9");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 45);
		
		//Precondition
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

}
