package com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUsers {
	
	WebDriver driver;
	
	public ViewSystemUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="searchSystemUser_userName")
	@CacheLookup
	WebElement searchUsername;
	
	@FindBy(id ="searchBtn")
	@CacheLookup
	WebElement searchutton;
	
	public void setSearchUsername(String username) {
		searchUsername.sendKeys(username);
	}
	
	public void clickSearchButton() {
		searchutton.click();
	}

}
