package com.hrms.testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;



public class AddEmployeesTest extends CommonMethods {

	@Test(groups = "smoke")
	public void addEmployee() throws IOException {

		sendText(login.usernameTextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.loginBtn);
		waitForClickability(dashboard.pim);
//		jsClick(dashboard.pim);
		click(dashboard.pim);
		click(addEmp.addEmpBtn);

		List<Map<String, String>> employeeList = ExcelUtility.excelToListMap(Constants.EXCELFILE_PATH, "Sample");
		SoftAssert soft = new SoftAssert();
		for (Map<String, String> map : employeeList) {
			int i = 1;
			
			String firstName = map.get("FirstName");
			String lastName = map.get("LastName");
			sendText(addEmp.firstName, firstName);
			sendText(addEmp.lastName, lastName);
			String id = addEmp.empId.getText();
			ExcelUtility.saveIntoExcel(Constants.EXCELFILE_PATH, "Sample", i, 5, id, Constants.EXCELFILE_PATH);
			i++;
			click(addEmp.save);
			soft.assertEquals(addEmp.empInfo.getText(), firstName + " " + lastName);
			waitForClickability(addEmp.addEmpBtn);
			jsClick(addEmp.addEmpBtn);
		}

//		ExcelUtility.openExcel(Constants.EXCELFILE_PATH);
//		ExcelUtility.getSheet("Sample");
//		for (int i = 1; i < ExcelUtility.getRowsCount(); i++) {
//			sendText(addEmp.firstName, ExcelUtility.getCellData(i, 0));
//			sendText(addEmp.lastName, ExcelUtility.getCellData(i, 2));
//			click(addEmp.save);
//			click(addEmp.addEmpBtn);
//		}
//		click(empList.empList);

	}
}
