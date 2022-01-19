package com.genericUtils;


import java.util.Random;
import java.util.Date;

/**
 * java utility class
 * @author Vijay ramachandra
 *
 */
public class JavaUtility {
	
	/**
	 * This method will generate random number in the range 5000
	 * @return 
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	/**
	 * This method will return date and time
	 * @return 
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
		
	}

}
