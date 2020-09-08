package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LoginPageElements extends BaseClass {
	@FindBy(id = "txtUsername")
	public WebElement usernameTextBox;

	@FindBy(id = "txtPassword")
	public WebElement passwordTextBox;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(id = "spanMessage")
	public WebElement errorMsg;

	public static final String ERROR_MESSAGE_BLANK_USERNAME = "Username cannot be empty";
	public static final String ERROR_MESSAGE_BLANK_PASSWORD = "Password cannot be empty";
	public static final String ERROR_MESSAGE_INVALID_PASSWORD = "Invalid credentials";

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
}
