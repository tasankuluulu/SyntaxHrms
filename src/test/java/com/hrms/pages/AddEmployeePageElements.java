package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements extends BaseClass {
	@FindBy(xpath = "//input[@name='chkLogin']")
	public WebElement loginDetailsCheckbox;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmpBtn;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;
	
	@FindBy(id = "employeeId")
	public WebElement empId;

	@FindBy(id = "btnSave")
	public WebElement save;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement FullName;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;
	
	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement empInfo;

	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}
}
