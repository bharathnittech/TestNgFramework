package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class AccountOverviewPage extends WebCommons{
	
	@FindBy(xpath="//a[text()='Accounts Overview']")
	private WebElement accountOverviewLink;
	
	By byaccountOverviewLink = By.xpath("//a[text()='Accounts Overview']");
	
	public void verifySuccessfulLogin() {
		waitForElement(byaccountOverviewLink);
		logInfo("Login is successful");
	}
	
	public static AccountOverviewPage getAccountOverviewPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AccountOverviewPage.class);
	}

}
