package com.chirag.seljava.ohrm.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement.users.SaveSystemUser;
import com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement.users.ViewSystemUsers;
import com.chirag.seljava.ohrm.resources.Base;

public class SaveSystemUserTest extends Base {
	
	@Test
	public void addUser() throws InterruptedException {
		ViewSystemUsers viewSystemUsers = new ViewSystemUsers(driver);
		viewSystemUsers.clickAddButton();
		
		Thread.sleep(3000);
		
		SaveSystemUser saveSystemUser = new SaveSystemUser(driver);
		saveSystemUser.setUserRole("Admin");
		saveSystemUser.setEmployeeName("robert craig");
		
		List<WebElement> allEmpList = saveSystemUser.totalDropdownEmployees();
		
		for(WebElement employee : allEmpList) {
			if(employee.getText().equalsIgnoreCase("robert craig")) {
				employee.click();
				break;
			}
		}
		
		saveSystemUser.setUsername("robert.craig123frdse34");
		saveSystemUser.setStatus("Enabled");
		saveSystemUser.setPassword("jfhejfgj!!!#9846836");
		saveSystemUser.setConfirmPassword("jfhejfgj!!!#9846836");
		saveSystemUser.clickSave();
		Thread.sleep(4000);
		if(viewSystemUsers.getSuccessMsg().isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

}
