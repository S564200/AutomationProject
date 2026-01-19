package com.orangehrm.app.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.orangehrm.app.utitlities.ReadConfig;

public class Baseclass {

    public static WebDriver driver;
    public static ReadConfig readconfig;

    public static String ApplicationUrl;
    public static String userName;
    public static String password;

    @BeforeSuite
    @Parameters("browser")
    public void setup(@Optional("chrome") String br) throws InterruptedException {

        readconfig = new ReadConfig();

        ApplicationUrl = readconfig.getFromConfingFile("ApplicationURL");
        userName = readconfig.getFromConfingFile("username");
        password = readconfig.getFromConfingFile("password");

        if (br.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        } else if (br.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    readconfig.getfirefoxPath());
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(ApplicationUrl);
        System.out.println("URL = " + ApplicationUrl);

        Thread.sleep(5000);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
    	    Thread.sleep(3000);
            driver.quit();
            System.out.println("after suite");
        }
    }

