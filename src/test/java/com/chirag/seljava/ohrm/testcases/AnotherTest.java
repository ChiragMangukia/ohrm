package com.chirag.seljava.ohrm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.chirag.seljava.ohrm.pageobjects.HomeLogin;
import com.chirag.seljava.ohrm.resources.Base;

public class AnotherTest extends Base {
	
	@Test
	public void login() throws InterruptedException {
		driver.get(homeURL);
		
		HomeLogin homeLogin = new HomeLogin(driver);
		homeLogin.setUsername(homeUsername);
		homeLogin.setPassword(homePassword);
		homeLogin.clickSubmit();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployee/empNumber/1");
		driver.findElement(By.id("btnSave")).click();
		datePicker("2039", "Apr", "30");
		Thread.sleep(1500);
	}
	
	public static void datePicker(String year, String month, String date) {
		
		driver.findElement(By.xpath("//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[2]/li[4]/img")).click();
		Select selectMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		selectYear.selectByVisibleText(year);
		driver.findElement(By.xpath("//tr//td//a[text()='" + date + "']")).click();
		//List<WebElement> datesList = driver.findElements(By.tagName("a"));
		//List<WebElement> datesList = driver.findElements(By.xpath("//a[text()='" + date + "']"));
		//for(WebElement cell : datesList) {
			//if(cell.getText().equals(date)) {
				//cell.findElement(By.xpath("//a[text()='" + date + "']")).click();
				//break;
			//}
		//}
		
	}
}
