package com.orangehrm.app.pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.app.testCases.Baseclass;

public class Myinfo {
	
	WebDriver ldriver;
	WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(Myinfo.class);
	public Myinfo(WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	wait = new WebDriverWait(rdriver, Duration.ofSeconds(10));
	
	}
	@FindBy(xpath = "//a[@href=\"/web/index.php/directory/viewDirectory\"]") WebElement MyDirectory;
	@FindBy(xpath = "//a[@href=\"/web/index.php/pim/viewMyDetails\"]") WebElement MyinfoInput; 
	@FindBy(xpath = "//input[@name=\"middleName\"]") WebElement inputname;
	@FindBy(xpath = "//button[normalize-space()='Save']") WebElement saveButton;
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]") WebElement searchemp;
	@FindBy(xpath = "//div[contains(@class,'oxd-select-text')]") WebElement dropdown;
	@FindBy(xpath = "//span[text()='Automaton Tester']") WebElement selectcourse;
	@FindBy(xpath = "//button[@type=\"submit\"]") WebElement searchbutton;
	@FindBy(xpath = "//a[@href=\"/web/index.php/time/viewTimeModule\"]") WebElement Timeselect;
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]") WebElement selectEmployee;
	@FindBy(xpath = "//button[@type=\"submit\"]") WebElement viewButton;
	@FindBy(xpath = "//a[@href=\"/web/index.php/recruitment/viewRecruitmentModule\"]") WebElement RecruitmentButton;
	@FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]") WebElement addButton;
	@FindBy(xpath = "//input[@name=\"firstName\"]") WebElement firstname;
	@FindBy(xpath = "//input[@name=\"lastName\"]") WebElement lastname;
	@FindBy(xpath = "//div[@class=\"oxd-select-text-input\"]") WebElement title;
	@FindBy(xpath = "//span[text()='Payroll Administrator']") WebElement selectTitle;
	@FindBy(xpath = "//input[@placeholder=\"Type here\"]") WebElement email;
	@FindBy(xpath = "//button[@type=\"submit\"]") WebElement submitButton;
	@FindBy(xpath = "//a[@href=\"/web/index.php/pim/viewPimModule\"]") WebElement PIMButton;
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]") WebElement emplyeename;
	@FindBy(xpath = "//input[@class=\"oxd-input oxd-input--active\"]") WebElement empid;
	@FindBy(xpath = "//button[@type=\"submit\"]") WebElement searchButton;
	@FindBy(xpath = "//label[contains(text(),'License Number')]/ancestor::div[contains(@class,'oxd-input-group')]//input") WebElement DLField;
	
	public void PIMDemo() throws InterruptedException {

	    logger.info("Navigating to PIM module");
	    wait.until(ExpectedConditions.elementToBeClickable(PIMButton)).click();
	    Thread.sleep(3000);
	    logger.info("Entering employee name: exampletest");
	    wait.until(ExpectedConditions.visibilityOf(emplyeename)).sendKeys("exampletest");
	    Thread.sleep(2000);
	    logger.info("Entering employee ID: 54678");
	    wait.until(ExpectedConditions.visibilityOf(empid)).sendKeys("54678");
	    Thread.sleep(3000);
	    logger.info("Clicking Search button");
	    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	    Thread.sleep(2000);
	    logger.info("Clearing employee ID field after search");
	    wait.until(ExpectedConditions.elementToBeClickable(empid)).click();

	    Actions pm = new Actions(ldriver);
	    pm.keyDown(Keys.CONTROL)
	      .sendKeys("a")
	      .keyUp(Keys.CONTROL)
	      .sendKeys(Keys.BACK_SPACE)
	      .perform();

	    logger.info("Employee ID field cleared successfully");
	}

	
	
	
	//this method is for Myinfo page
	public void savebutton() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("Navigating to My Info page");
		wait.until(ExpectedConditions.elementToBeClickable(MyinfoInput)).click();
		Thread.sleep(3000);
		// created actions class for clearning the existing data and for scrolling to particular element.
		 logger.info("Clearing middle name field");
		Actions ac = new Actions(ldriver);
		wait.until(ExpectedConditions.elementToBeClickable(inputname)).click();
		logger.info("Clearing middle name field");
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("a");
		ac.keyUp(Keys.CONTROL);
		ac.sendKeys(Keys.BACK_SPACE);
		ac.build().perform();
		logger.info("Updating middle name to: Jonah");
		inputname.sendKeys("Jonah");
		//Thread.sleep(3000);
wait.until(ExpectedConditions.elementToBeClickable(DLField)).click();
//		ac.keyDown(Keys.CONTROL);
//		ac.sendKeys("a");
//		ac.keyUp(Keys.CONTROL);
//		ac.sendKeys(Keys.BACK_SPACE);
//		ac.build().perform();
logger.info("Clearing Driving License field");
       DLField.clear();
       Thread.sleep(3000);
       logger.info("Updating Driving License number");
       DLField.sendKeys("DL-456234");		
		Thread.sleep(5000);
		ac.scrollToElement(saveButton).build().perform();
		Thread.sleep(3000);
		saveButton.click();
		logger.info("My Info details saved successfully");
		
	}
	
	public void directoryinfo() throws InterruptedException {

	    Actions actions = new Actions(ldriver);
	    logger.info("Navigating to MyDirectory page");
	    wait.until(ExpectedConditions.elementToBeClickable(MyDirectory)).click();
	    logger.info("Searching with a random name");
	    wait.until(ExpectedConditions.visibilityOf(searchemp)).sendKeys("Minh exampletest Nguyen");
	  //  Thread.sleep(3000);
	    logger.info("Clicked the dropdown");
	    wait.until(ExpectedConditions.elementToBeClickable(dropdown));
	    actions.moveToElement(dropdown).click().perform();
	   Thread.sleep(3000);
	   logger.info("Selected course");
	    wait.until(ExpectedConditions.visibilityOf(selectcourse));
	    actions.moveToElement(selectcourse).click().perform();
	    logger.info("Search operation is done");
	    wait.until(ExpectedConditions.elementToBeClickable(searchbutton)).click();
	}
	
	public void Recruitmentpage() throws InterruptedException {
		logger.info("Navigating to Recruitementpage");
		wait.until(ExpectedConditions.elementToBeClickable(RecruitmentButton)).click();
		logger.info("Clicked add button");
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
		Thread.sleep(3000);
		logger.info("Added required fields");
		wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys("exampletestfirst");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys("lastnametest");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(title)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(selectTitle)).click();
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("example@gmail.com");
		Thread.sleep(3000);
		Actions acr = new Actions(ldriver);
		logger.info("Added details successfully");
		acr.scrollToElement(submitButton);
		acr.build().perform();
		submitButton.click();
		
	}
	
	public void Timesheetmethod() throws InterruptedException {
		logger.info("Navigating to Timesheet page Module");
		 wait.until(ExpectedConditions.elementToBeClickable(Timeselect)).click();
		Thread.sleep(3000);
		logger.info("Searching a employee name");
		selectEmployee.sendKeys("manda demotest user2");
		Thread.sleep(3000);
		logger.info("Clicked view Button");
		viewButton.click();
		
		
	}
}
