package com.orangehrm.app.testCases;

import org.testng.annotations.Test;

import com.orangehrm.app.pageobjects.LoginPage;
import com.orangehrm.app.pageobjects.LogoutPage;
import com.orangehrm.app.pageobjects.Myinfo;

public class TC_Myinfo extends Baseclass {
	
	@Test
	public void Myinfotest() throws InterruptedException {
		// login into application
		LoginPage lg = new LoginPage(driver);
		lg.setUSername(userName);
		lg.setPassword(password);
		lg.clickLogin();
		
		Thread.sleep(3000);
		
		Myinfo myinfo = new Myinfo(driver);
		myinfo.savebutton();
		Thread.sleep(3000);
		myinfo.PIMDemo();
		myinfo.Recruitmentpage();
		myinfo.directoryinfo();
		myinfo.Timesheetmethod();
		
		
		Thread.sleep(3000);
		LogoutPage log = new LogoutPage(driver);
		log.logoutMethod();
		
		
		
		
	}

}
