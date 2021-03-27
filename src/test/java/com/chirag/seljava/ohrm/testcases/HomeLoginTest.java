package com.chirag.seljava.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chirag.seljava.ohrm.resources.Base;
import com.chirag.seljava.ohrm.pageobjects.HomeLogin;

public class HomeLoginTest extends Base {
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get(homeURL);
		
		HomeLogin homeLogin = new HomeLogin(driver);
		homeLogin.setUsername(homeUsername);
		homeLogin.setPassword(homePassword);
		homeLogin.clickSubmit();
		
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard1234";
		
		if(driver.getCurrentUrl().equals(expectedURL)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "URL is not as expected");
		}
	}

}
