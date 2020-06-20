package com.chirag.seljava.ohrm.pageobjects.mainmenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuOptions {
	
	WebDriver driver;
	
	public MenuOptions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="menu_admin_viewAdminModule")
	@CacheLookup
	WebElement viewAdminModule;
	
	public void hoverViewAdminModule() {
		Actions actions = new Actions(driver);
		actions.moveToElement(viewAdminModule).perform();
	}

}
