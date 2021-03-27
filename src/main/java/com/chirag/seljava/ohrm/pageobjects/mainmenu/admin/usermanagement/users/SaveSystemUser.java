package com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement.users;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SaveSystemUser {
	
	WebDriver driver;
	
	public SaveSystemUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="systemUser_userType")
	@CacheLookup
	WebElement ddlUserRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	@CacheLookup
	WebElement txtEmployeeName;
	
	@FindBy(xpath ="//div[@class='ac_results']/ul/li[starts-with(@class,'ac_')]")
	@CacheLookup
	List<WebElement> allDropdownEmployeees;
	
	@FindBy(id="systemUser_userName")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(id="systemUser_status")
	@CacheLookup
	WebElement ddlStatus;
	
	@FindBy(id="systemUser_password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="systemUser_confirmPassword")
	@CacheLookup
	WebElement txtConfirmPassword;
	
	@FindBy(id="btnSave")
	@CacheLookup
	WebElement btnSave;
	
	public void setUserRole(String userRoll) {
		Select select = new Select(ddlUserRole);
		select.selectByVisibleText(userRoll);
	}
	
	public void setEmployeeName(String empName) {
		txtEmployeeName.sendKeys(empName);
	}
	
	public List<WebElement> totalDropdownEmployees() {
		return allDropdownEmployeees;
	}
	
	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setStatus(String status) {
		Select select = new Select(ddlStatus);
		select.selectByVisibleText(status);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}
	
	public void clickSave() {
		btnSave.click();
	}

}
