package com.orangehrm.app.pageobjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']") WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']") WebElement logoutButton;

    public void logoutMethod() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
