package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.EmployeeListPageElements;
import com.hrms.pages.LoginPageElements;

public class PagesInitializer extends BaseClass {

	protected static LoginPageElements login;
	protected static AddEmployeePageElements addEmp;
	protected static DashboardPageElements dashboard;
	protected static EmployeeListPageElements empList;

	public static void initializePageObjects() {
		login = new LoginPageElements();
		addEmp = new AddEmployeePageElements();
		dashboard = new DashboardPageElements();
		empList = new EmployeeListPageElements();

	}

}
