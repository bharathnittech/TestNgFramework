package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.application.pages.FlipKartHomePage;
import com.application.pages.SecurePayment;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass{
	
	
	  @Test(priority=1)
	  public void verifyApplicationTitle() { 
	FlipKartHomePage  homepage = FlipKartHomePage.getHomePage(); 
	homepage.launchApplication();
	  homepage.verifyTitle(); }
	 
	
	  @Test(priority=2) public void addProductToCartInApp() {
	  
	  FlipKartHomePage homepage = FlipKartHomePage.getHomePage();
	  homepage.launchApplication(); homepage.addProductTOCart(); }
	 
	
	
	
	  @Test(priority=3)
	  
	  public void VerifyProductAddedTOCart() { FlipKartHomePage homepage =
	  FlipKartHomePage.getHomePage(); homepage.launchApplication();
	  homepage.addProductTOCart(); SecurePayment sp =
	  SecurePayment.getSecurePaymentPage(); sp.verifyIsProductAddToCart();
	  sp.verifyProductName(); }
	  
	  @Test(priority=4,dataProvider="loginData")
	 
	  public void placeOrderAndRemoveProduct(String Email,String Password) { 
		  FlipKartHomePage homepage = FlipKartHomePage.getHomePage();
		  homepage.launchApplication();
		  homepage.addProductTOCart(); 
		  SecurePayment sp = SecurePayment.getSecurePaymentPage();
		  sp.PlaceOrder(Email,Password);
	      homepage.removeProduct(); 
	      }
	  
	  
	  
		@DataProvider(name="loginData")
		public String [][] loginData() {
			String [][] data = ReadExcel.readData("TestData.xlsx", "LoginData");
			return data;
		}

	
}