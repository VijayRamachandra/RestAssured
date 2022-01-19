package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAllProjects {
	
	@Test
	public void GetAllProjects() {
		
		Response res = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(res.prettyPeek());
		
		res.then().assertThat().statusCode(200);
		res.then().assertThat().contentType("application/json");
		
	}

}
