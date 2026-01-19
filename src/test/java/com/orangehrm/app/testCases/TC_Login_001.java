package com.orangehrm.app.testCases;

import org.testng.annotations.Test;

import com.orangehrm.app.pageobjects.LoginPage;


public class TC_Login_001 extends Baseclass {
	@Test
	public void login() {
		String test01 = "Login Test";
		LoginPage lp = new LoginPage(driver);
		lp.setUSername(userName);
		lp.setPassword(password);
		lp.clickLogin();
		

	}
}


