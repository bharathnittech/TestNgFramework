package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class ForgotPassPage extends WebCommons{
	
	By forgotPassPageHeader = By.xpath("//h1[@class='title']");
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='address.street']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='address.city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='address.state']")
	private WebElement state;
	
	@FindBy(xpath="//input[@id='address.zipCode']")
	private WebElement zipCode;
	
	@FindBy(xpath="//input[@id='ssn']")
	private WebElement ssn;
	
	@FindBy(xpath="//input[@value='Find My Login Info']")                                     
	private WebElement findLoginInfoBtn;
	
	public void verifyForgotPassPage() {
		waitForElement(forgotPassPageHeader);
		logInfo("Registration page successfully launched");
	}	
	
	public static ForgotPassPage getForgotPassPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), ForgotPassPage.class);
	}

}
