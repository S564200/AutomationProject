	package com.orangehrm.app.pageobjects;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	public class LoginPage {
		
		//creating web driver
		WebDriver ldriver;
		public LoginPage(WebDriver rdriver)
		{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		}
	    // finding the elements by xpath
		@FindBy(name = "username") WebElement userNameInput;
		@FindBy(name = "password") WebElement passwordInput;
		@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
		
		// setting username and password
		public void setUSername(String userName)
		{
			userNameInput.sendKeys(userName);
		}
		
		public void setPassword(String password) {
			passwordInput.sendKeys(password);
		}
		
		public void clickLogin() {
	        loginButton.click();
	    }
		
		//This Method is used to perform login and passing the username & password directly.
		public void login(String userName,String password)
		{
			
			userNameInput.sendKeys(userName);
			passwordInput.sendKeys(password);
			loginButton.click();
		}
	
	}
