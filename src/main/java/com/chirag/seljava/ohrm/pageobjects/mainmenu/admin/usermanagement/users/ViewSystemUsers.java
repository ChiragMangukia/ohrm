package com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement.users;

import java.util.List;

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
	
	@FindBy(name ="searchSystemUser[employeeName][empName]")
	@CacheLookup
	WebElement searchSystemUser;
	
	@FindBy(xpath ="//div[@class='ac_results']/ul/li[starts-with(@class,'ac_')]")
	@CacheLookup
	List<WebElement> allDropdownEmployeees;
	
	@FindBy(id ="searchBtn")
	@CacheLookup
	WebElement searchutton;
	
	@FindBy(id ="btnAdd")
	@CacheLookup
	WebElement addButton;
	
	@FindBy(xpath = "//*[@id=\"frmList_ohrmListComponent\"]/div[2]")
	@CacheLookup
	WebElement successMSG;
	
	public void setSearchUsername(String username) {
		searchUsername.sendKeys(username);
	}
	
	public void setSearchSystemUser(String employeeName) {
		searchSystemUser.sendKeys(employeeName);
	}
	
	public void clickSearchButton() {
		searchutton.click();
	}
	
	public List<WebElement> totalDropdownEmployees() {
		return allDropdownEmployeees;
	}
	
	public void clickAddButton() {
		addButton.click();
	}
	
	public WebElement getSuccessMsg() {
		return successMSG;
	}

}
