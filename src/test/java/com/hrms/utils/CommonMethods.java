package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PagesInitializer;

public class CommonMethods extends PagesInitializer {
	/**
	 * Method that sends text to any given web element
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method returns object of JavascriptExecutor type
	 * 
	 * @return JavascriptExecutor object
	 */
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		return js;
	}

	/**
	 * Method performs click using JavascriptExecutor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click;", element);
	}

	/**
	 * Method scrolls up using JavaScript Executor
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0, -" + pixel + ")");
	}

	/**
	 * Method scrolls down using JavaScript Executor
	 * 
	 * @param pixel
	 */
	public static void srollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	}

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * Method reads excel file and returns the cell value
	 * 
	 * @param sheetName - Needed sheet name
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
	public static String getFromExcel(String sheetName, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(Constants.EXCELFILE_PATH);
		Workbook wbook = new XSSFWorkbook(fis);
		Sheet sheet = wbook.getSheet(sheetName);
		Row row2 = sheet.getRow(row);
		return sheet.getRow(row).getCell(cell).toString();
	}

	public static void writeIntoExcel(String sheet, int row, int cell, String value) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.EXCELFILE_PATH);
		Workbook book = new XSSFWorkbook(fis);

		book.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(Constants.EXCELFILE_PATH);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
	}
	
	

}
