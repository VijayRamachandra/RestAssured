package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteProject {
	
	@Test
	public void DeleteProject() {
		
		//Delete
//		int expectedStatus = 204;
		Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_202");
		
		res.then().assertThat().statusCode(204);
		
		/*
		 * //Get Status int actualStatus = res.getStatusCode();
		 * 
		 * //Validate Assert.assertEquals(expectedStatus, actualStatus);
		 * System.out.println(res.prettyPeek());
		 */
	}

}
