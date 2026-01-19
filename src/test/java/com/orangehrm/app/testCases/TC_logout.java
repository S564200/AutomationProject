package com.orangehrm.app.testCases;

import org.testng.annotations.Test;

import com.orangehrm.app.pageobjects.LoginPage;
import com.orangehrm.app.pageobjects.LogoutPage;

public class TC_logout extends Baseclass  {
	
	@Test
	public void logout() throws InterruptedException {
		//We need to login first 
		
		LoginPage login = new LoginPage(driver);
		login.setUSername(userName);
		login.setPassword(password);
		login.clickLogin();
		LogoutPage lgout = new LogoutPage(driver);
		lgout.logoutMethod();
	}


	}


