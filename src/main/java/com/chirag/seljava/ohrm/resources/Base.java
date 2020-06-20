package com.chirag.seljava.ohrm.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
	
	public static WebDriver driver;
	public static String homeURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	public static String homeUsername = "Admin";
	public static String homePassword = "admin123";
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
