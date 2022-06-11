package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reports.ExtentReportsClass;
import com.framework.webdriver.WebDriverClass;
import com.relevantcodes.extentreports.LogStatus;

public class WebCommons {

	// This class will have all the common methods to handle web applications

	public WebDriver driver = WebDriverClass.getDriver();
	public static final int WAIT_TIME = 30;

	// Method to perform scroll to element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	// Method to perform click action
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	// Method to perform java script click
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// Method to Enter text in textbox
	public void enterInfo(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}

	// Method to select option from dropdown
	public void selectOption(WebElement element, String by, String option) {
		Select s = new Select(element);
		if (by.equalsIgnoreCase("value")) {
			s.selectByValue(option);
		} else if (by.equalsIgnoreCase("visibleText")) {
			s.selectByVisibleText(option);
		} else if (by.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(option));
		} else {
			Assert.fail("Wrong method ");
		}
	}

	// Method to select checkbox
	public void selectCheckbox(WebElement element) {
		scrollToElement(element);
		if (!element.isSelected())
			element.click();
	}
	
	//Method to perform Implicit Wait
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
	}
	
	//Method to wait for element (Explicit wait)
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,WAIT_TIME);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//Method to wait for particular amount of time
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Method to take screenshots and share screenshot path
	public String  takeScreenshot(String screenshotName) {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName+".png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	//Method to generate unique id 
	public String getUniqueId() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
		String uniqueId = sdf.format(Calendar.getInstance().getTime());
		return uniqueId;
	}
	
	//Method to get Title of page
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	//Method to get text of element
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	//Method to get  element attribute value
	public String getElementAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	//Method to print custom messages 
	public void logInfo(String message) {
		ExtentReportsClass.print.log(LogStatus.INFO, message);
	}
}
