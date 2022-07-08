package com.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.framework.reports.ExtentReportsClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass extends ExtentReportsClass{
	
	//This class will contain all the methods related to browser
	
	protected WebDriver driver;
	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();
	
	//This method will be used to launch browser 
	
	@BeforeMethod(alwaysRun=true)
	@Parameters(value="browser")
	public void setupBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--start-maximized");
		    options.addArguments("--disable-popup-blocking");

			driver = new ChromeDriver(options);
			//driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			Assert.fail("Invalid Browser");
		}
		setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}

	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
	//	driver.quit();
	}
	
	public static synchronized void setDriver(WebDriver driver) {
		thread.set(driver);
	}
	
	public static synchronized WebDriver getDriver() {
		return thread.get();
	}
}
