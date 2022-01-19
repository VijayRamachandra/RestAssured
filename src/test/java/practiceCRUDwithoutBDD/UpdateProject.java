package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void UpdateProject() {
		
		// prepare request body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Hari Kishan");
		jobj.put("projectName", "SDET-25");
		jobj.put("status", "On going");
		jobj.put("teamSize", 50);
		
		//request specification
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//action
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_802");
		
		//validation-print in console
		System.out.println(res.prettyPeek());
		
		res.then().assertThat().statusCode(200);
		res.then().assertThat().contentType("application/json");
	}

}
