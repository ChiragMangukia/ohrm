package com.chirag.seljava.ohrm.pageobjects.mainmenu.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSubMenu {
	
	WebDriver driver;
	
	public AdminSubMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="menu_admin_UserManagement")
	@CacheLookup
	WebElement userManagement;
	
	public void hoverUserManagement() {
		Actions actions = new Actions(driver);
		actions.moveToElement(userManagement).perform();
	}

}
