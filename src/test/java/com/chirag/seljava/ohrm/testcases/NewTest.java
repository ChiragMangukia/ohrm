package com.chirag.seljava.ohrm.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.chirag.seljava.ohrm.pageobjects.HomeLogin;
import com.chirag.seljava.ohrm.resources.Base;
import com.chirag.seljava.ohrm.utilities.XLUtils;

public class NewTest extends Base{
	
	@Test
	public void login() {
		driver.get(homeURL);
		
		HomeLogin homeLogin = new HomeLogin(driver);
		homeLogin.setUsername(homeUsername);
		homeLogin.setPassword(homePassword);
		homeLogin.clickSubmit();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
	}
	
	@Test(dataProvider = "RegistrationData")
	public void newTest(String firstname, String lastname, String empId, String username, String password, String status) throws InterruptedException {
		
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys(empId);
		driver.findElement(By.id("chkLogin")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement btnSaveButton = driver.findElement(By.id("btnSave"));
		js.executeScript("arguments[0].scrollIntoView();", btnSaveButton);
		driver.findElement(By.id("user_name")).sendKeys(username.toLowerCase());
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		Select select = new Select(driver.findElement(By.id("status")));
		select.selectByVisibleText(status);
		
		btnSaveButton.click();
		Thread.sleep(5000);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
	}
	
	@DataProvider(name = "RegistrationData")
	String[][] getData() throws IOException {
		String path = "E:\\Programming\\ohrm\\Testdata\\TestData.xlsx";
		String sheetName = "EmployeeInfo";
		return XLUtils.getExcelData(path, sheetName);
	}

}
