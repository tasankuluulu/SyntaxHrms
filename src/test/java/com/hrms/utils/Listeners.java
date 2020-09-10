package com.hrms.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

	public void onTestSuccess(ITestResult result) {
		CommonMethods.takeScreenshot("passed\\" + result.getName() + timestamp);
	}

	public void onTestFailure(ITestResult result) {
		CommonMethods.takeScreenshot("failed\\" + result.getName() + timestamp);
	}
}
