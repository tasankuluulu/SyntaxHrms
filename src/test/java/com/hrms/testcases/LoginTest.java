package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.Properties;

import org.apache.commons.math3.stat.interval.ConfidenceInterval;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class LoginTest extends CommonMethods {

	@Test(groups = "smoke")
	public void validLogin() {

		sendText(login.usernameTextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.loginBtn);

		Assert.assertEquals(dashboard.welcomeMsg.getText(), "Welcome " + ConfigsReader.getPropValue("username"));
	}

	@Test(groups = "regression", dataProvider = "getData")
	public void invalidLogin(String username, String password, String expectedErrMessage) {

		sendText(login.usernameTextBox, username);
		sendText(login.passwordTextBox, password);
		click(login.loginBtn);

		Assert.assertEquals(login.errorMsg.getText(), expectedErrMessage);

	}

	@DataProvider
	public String[][] getData() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String[][] data = { { "", ConfigsReader.getPropValue("password"), login.ERROR_MESSAGE_BLANK_USERNAME },
				{ ConfigsReader.getPropValue("username"), "", login.ERROR_MESSAGE_BLANK_PASSWORD },
				{ ConfigsReader.getPropValue("username"), "123", login.ERROR_MESSAGE_INVALID_PASSWORD } };
		return data;
	}
}
