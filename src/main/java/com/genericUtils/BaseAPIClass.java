package com.genericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * Base API class is used to provide all the repeted actions
 * @author Vijay Ramachandra
 *
 */
public class BaseAPIClass {
	public JavaUtility jUtil = new JavaUtility();
	public DataBaseUtility dbUtil = new DataBaseUtility();
	public JsonUtility jsonUtil = new JsonUtility();
	@BeforeSuite
	public void BS() throws Throwable {
		
		System.out.println("Data Base Connection is Started");
		dbUtil.connectToDB();
		System.out.println("Connected to DataBase");
		baseURI = "http://localhost";
		port=8084;
	}
	@AfterSuite
	public void AS() {
		dbUtil.closeDataBaseConnection();
		System.out.println("DataBase is closed");
	}
}
