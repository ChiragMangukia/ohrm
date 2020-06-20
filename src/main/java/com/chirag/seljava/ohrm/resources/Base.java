package com.chirag.seljava.ohrm.resources;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

public class Base {
	
	private static Logger log = loggingMethod(Base.class.getName());
	
	public static WebDriver driver;
	public static String homeURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	public static String homeUsername = "Admin";
	public static String homePassword = "admin123";
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Chrome driver initialized and broswer maximized");
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
		log.info("Driver quit");
	}
	
	public static Logger loggingMethod(String className) {
		return LogManager.getLogger(className);
	}
	
	public void getScreenshot(String fileName) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File(fileName + ".png"));
	}
}
