package com.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * Data Base Utility Class
 * @author Vijay Ramachandra
 * 
 */
public class DataBaseUtility {

	Connection connection = null;
	/**
	 * This method will connect the data base
	 */

	public void connectToDB() throws Throwable{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(IpathConstant.DATABASE_URL,"root","root");
	}

	/**
	 * This method will close the data base connection
	 * @throws SQLException 
	 */
	public void closeDataBaseConnection(){
		try{
			connection.close();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will get all the data from database
	 * @param query
	 * @return
	 */
	public ResultSet getAllDataFromDataBase(String query) {
		ResultSet result = null; 
		try {
			result = connection.createStatement().executeQuery(query);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method will match the column data based on expected data
	 * @return 
	 * @throws SQLException 
	 */
	public String getAndVerifyTheData(String query, int columnNumber, String expectedData) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(query);
		String actualData = null;
		boolean flag = false;
		try {
			while(result.next()) {
				String dbData = result.getString(columnNumber);
				if (dbData.equals(expectedData)) {
					actualData = dbData;
					flag=true;
					break;
				}
			}
		}catch (Exception e) {

		}

		if (flag) {
			System.out.println("Data is present and verified");
		}else {
			System.out.println("Data is not present");
			return actualData;
		}
		return actualData;
	}
}


