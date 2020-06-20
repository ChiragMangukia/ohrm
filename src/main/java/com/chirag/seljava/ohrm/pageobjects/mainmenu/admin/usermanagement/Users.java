package com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users {

	WebDriver driver;
	
	public Users(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="menu_admin_viewSystemUsers")
	@CacheLookup
	WebElement viewSystemUsers;
	
	public void clickViewSystemUsers() {
		viewSystemUsers.click();
	}

}
