package com.w2a.testcases;

import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;


public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postCode) throws InterruptedException {
		//driver.findElement(By
				//.xpath("//body[@class='ng-scope']//div[@class='ng-scope']//div[@class='ng-scope']//div[2]//button[1]"))
				//.click();
		driver.findElement(By.xpath("//button[@ng-click='addCust()']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(postCode);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
	}

	@DataProvider
	public Object[][] getData() {
		String sheetname = "AddCustomerTest";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
			}
		}
		return data;
	}

}
