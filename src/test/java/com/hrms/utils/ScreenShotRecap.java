package com.hrms.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class ScreenShotRecap extends CommonMethods {

	/*
	 * 1. why do we need to take screenshots --> verification 2. Why failures
	 * happens in our web application? - Difference in expected and actial values -
	 * NoSuchElementException - Unexpected alerts inside the application - Assertion
	 * issues
	 */

	@Test
	public static void login() {
		/*
		 * How to take screenshot - TakeScreenshot interface - getScreenshotAs()
		 * 
		 * ChromeDriver extends RemoteWebDriver RemoteWebDriver implements
		 * TakeScreenshot interface
		 */

		login.login();
		// 1. Create an Object of TakesScreenshot interface indirectly
		TakesScreenshot ts = (TakesScreenshot) driver;

		// 2. Create an object of File Class
		File file = ts.getScreenshotAs(OutputType.FILE);
		// 3. Save file as png or jpg type picture under requested folder
		try {
			FileUtils.copyFile(file, new File("screenshots/OrangeHRM/LoginTest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
