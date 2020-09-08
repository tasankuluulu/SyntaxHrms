package com.hrms.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeesTest extends CommonMethods {

	@Test(groups = "smoke")
	public void addEmployee() throws IOException {

		sendText(login.usernameTextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.loginBtn);
		click(dashboard.pim);

		for (int i = 1; i < 12; i++) {
			click(addEmp.addEmpBtn);
			sendText(addEmp.firstName, getFromExcel("Sample", i, 0));
			sendText(addEmp.lastName, getFromExcel("Sample", i, 1));
			writeIntoExcel("Sample", i, 4, addEmp.empId.getText());
			click(addEmp.loginDetailsCheckbox);
			sendText(addEmp.username, getFromExcel("Sample", i, 2));
			sendText(addEmp.password, getFromExcel("Sample", i, 3));
			sendText(addEmp.confirmPassword, getFromExcel("Sample", i, 3));
			click(addEmp.save);
		}
		click(empList.empList);
		for(WebElement row:empList.rows) {
			if()
		}

	}
}
