package com.application.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.commons.WebCommons;
import com.framework.utils.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons{
	
	//Login Page Elements
	
	@FindBy(xpath="//img[@class='logo']")
	private WebElement logo;
	
	@FindBy(xpath="//p[@class='caption']")
	private WebElement caption;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameTxtb;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTxtb;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Forgot login info?']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerLink;
	
	//Login Page Actions
	
	public void launchApplication() {
		driver.get(ReadProp.readData("Config.properties").getProperty("url"));
		logInfo("Application successfully Launched");
	}
	
	public void verifyTitle() {
		Assert.assertEquals(ReadProp.readData("Config.properties").getProperty("title"), getPageTitle());
		logInfo("Application title is matching");

	}

	public void verifyApplicationCaption() {
		Assert.assertEquals(ReadProp.readData("Config.properties").getProperty("caption"), getElementText(caption));
		logInfo("Application caption is matching");

	}
	
	public void loginIntoApplication(String username, String password) {
		enterInfo(usernameTxtb, username);
		enterInfo(passwordTxtb, password);
		click(loginBtn);
		logInfo("Login into the application");
	}
	
	public void getRegistrationPage() {
		click(registerLink);
		logInfo("Click on Registration Link");

	}
	
	public void getForgotLoginInfoPage() {
		click(forgotPasswordLink);
		logInfo("Click on forgot login info Link");

	}
	
	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}
}
