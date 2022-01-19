package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetSingleProject {
	
	@Test
	public void GetSingleProject() {
		
		Response res = RestAssured.get("http://localhost:8084/projects/TY_PROJ_807");
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
		res.then().assertThat().statusCode(200);
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		res.then().assertThat().contentType("application/json");
		
	}
	

}
