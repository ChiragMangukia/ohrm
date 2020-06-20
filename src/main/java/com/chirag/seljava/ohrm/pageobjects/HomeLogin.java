package com.chirag.seljava.ohrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLogin {
	
	WebDriver driver;
	
	public HomeLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "txtUsername")
	@CacheLookup
	WebElement username;
	
	@FindBy(name = "txtPassword")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "Submit")
	@CacheLookup
	WebElement submit;
	
	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		submit.click();
	}

}
