package practiceCRUDwithoutBDD;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createProject {

	@Test
	public void createProject() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Vijay");
		jobj.put("projectName", "SDET-31");
		jobj.put("status", "Created");
		jobj.put("teamSize", 50);

		//Provide request body using given
		RequestSpecification request = RestAssured.given();

		request.contentType(ContentType.JSON);
		request.body(jobj);

		//Action - Create post request
		Response resp = request.post("http://localhost:8084/addProject");

		//validation and print the response
		System.out.println(resp.asString());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.getContentType());
		System.out.println(resp.getSessionId());
		System.out.println(resp.getStatusCode());

		int expectedStatusCode = 201; 
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);

	}

}
