package com.orangehrm.app.utitlities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Webdriverutils {
	
    //This method will capture the screenshot and store it	
	public String captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		String errflpath = destination.getAbsolutePath();
		FileUtils.copyFile(srcFile, destination);
		System.out.println("Screenshot taken");
		return errflpath;
		}
	
	//Add a reusable method to switch to a Frame - By index,by visible text and By name or webelement
	

}