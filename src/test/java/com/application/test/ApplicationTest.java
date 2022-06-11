package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.pages.AccountOverviewPage;
import com.application.pages.ForgotPassPage;
import com.application.pages.LoginPage;
import com.application.pages.RegistrationPage;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass{
	
	@Test(priority=1,groups= {"Smoke","Sanity"})
	public void verifyApplicationTitle() {		
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.launchApplication();
		loginpage.verifyTitle();
	}
	
	@Test(priority=2,groups= {"Sanity"})
	public void verifyApplicationCaption() {		
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.launchApplication();
		loginpage.verifyApplicationCaption();
	}

	@Test(priority=3,groups= {"Regression"},dataProvider="loginData")
	public void verifyApplicationLogin(String username,String password) {		
		LoginPage loginpage = LoginPage.getLoginPage();
		AccountOverviewPage aoPage =AccountOverviewPage.getAccountOverviewPage();
		loginpage.launchApplication();
		loginpage.loginIntoApplication(username, password);
		aoPage.verifySuccessfulLogin();
	}
	
	@Test(priority=4,groups= {"Sanity"})
	public void verifyRegistrationPage() {		
		LoginPage loginpage = LoginPage.getLoginPage();
		RegistrationPage regPage = RegistrationPage.getRegistrationPage();
		loginpage.launchApplication();
		loginpage.getRegistrationPage();
		regPage.verifyRegPage();
	}
	
	@Test(priority=5,groups= {"Sanity"})
	public void verifyForgotPassword() {		
		LoginPage loginpage = LoginPage.getLoginPage();
		ForgotPassPage forgotPasspage = ForgotPassPage.getForgotPassPage();
		loginpage.launchApplication();
		loginpage.getForgotLoginInfoPage();
		forgotPasspage.verifyForgotPassPage();
	}
	
	@DataProvider(name="loginData")
	public String [][] loginData() {
		String [][] data = ReadExcel.readData("TestData.xlsx", "LoginData");
		return data;
	}
}
