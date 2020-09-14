package com.hrms.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.hrms.pages.LoginPageElements;

public class ActionsClassRecap {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		// 1. Create an obkect of Actions class
		Actions action = new Actions(driver);
		
		// 2. Create a locator for the page object
		WebElement leaveBtn = driver.findElement(By.id("menu_leave_viewLeaveModule"));
		action.moveToElement(leaveBtn).perform();
		WebElement configBtn = driver.findElement(By.id("menu_leave_Configure"));
		WebElement workWeekBtn = driver.findElement(By.id("menu_leave_defineWorkWeek"));
		action.moveToElement(configBtn).click(workWeekBtn).perform();
		Thread.sleep(2000);
		driver.quit();
		
		/*
		 * Most common methods of the Actions class for mouse
		 * 	- click()
		 *  - doubleClick()
		 *  - contextClick()
		 *  - dragAndDrop()
		 *  - moveToElement()
		 *  
		 *  Most common keyboard operations
		 *   - TAB
		 *   - CTRL
		 *   - SHIFT
		 *   - 
		 */
	}

}
