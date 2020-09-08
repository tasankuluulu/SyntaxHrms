package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {

	protected static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		switch (ConfigsReader.getPropValue("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", Constants.EDGEDRIVER_PATH);
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getPropValue("applicationUrl"));
		PagesInitializer.initializePageObjects();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
