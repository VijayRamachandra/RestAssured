package com.genericUtils;

import io.restassured.response.Response;

public class JsonUtility {
	
	/**
	 * This method will return the data from response based on json path
	 * @param response
	 * @param jsonPath
	 * @return
	 */
	public String getJsonDataValue(Response response,String jsonPath) {
		String jsonData = response.jsonPath().get(jsonPath);
		return jsonData;
		
	}

}
