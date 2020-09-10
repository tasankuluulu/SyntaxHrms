package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPageElements extends BaseClass {

	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement empList;
	
	@FindBy(id = "empsearch_id")
	public WebElement id;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	public List<WebElement> empListRows;

	public EmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}

}
