package com.chirag.seljava.ohrm.testcases;

import org.testng.annotations.Test;

import com.chirag.seljava.ohrm.pageobjects.HomeLogin;
import com.chirag.seljava.ohrm.pageobjects.mainmenu.MenuOptions;
import com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.AdminSubMenu;
import com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement.Users;
import com.chirag.seljava.ohrm.pageobjects.mainmenu.admin.usermanagement.users.ViewSystemUsers;
import com.chirag.seljava.ohrm.resources.Base;

public class ViewSystemUsersTest extends Base {
	
	@Test
	public void searchSystemUsers() throws InterruptedException {
		driver.get(homeURL);
		
		HomeLogin homeLogin = new HomeLogin(driver);
		homeLogin.setUsername(homeUsername);
		homeLogin.setPassword(homePassword);
		homeLogin.clickSubmit();
		
		MenuOptions menuOptions = new MenuOptions(driver);
		menuOptions.hoverViewAdminModule();
		AdminSubMenu adminSubMenu = new AdminSubMenu(driver);
		adminSubMenu.hoverUserManagement();
		Users users = new Users(driver);
		users.clickViewSystemUsers();
		ViewSystemUsers viewSystemUsers = new ViewSystemUsers(driver);
		viewSystemUsers.setSearchUsername("Admin");
		viewSystemUsers.clickSearchButton();
		
		Thread.sleep(5000);
	}

}
