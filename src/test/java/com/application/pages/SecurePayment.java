package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.commons.WebCommons;
import com.framework.utils.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class SecurePayment extends WebCommons {
	
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
	private WebElement productNameSelected;
	
	@FindBy(xpath="//div[@class='_3g_HeN']")
	private WebElement myCartnumber;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement placeOrder;
	
	@FindBy(xpath="//input[@class='_2IX_2- _17N0em']")
	private WebElement email;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _20xBvF _3AWRsL']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//*[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input")
	private WebElement mobile;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh _17N0em']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _20xBvF _3AWRsL']")
	private WebElement login;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _1seccl _3AWRsL']")
	private WebElement orderSummary;
	
	@FindBy(xpath="//label[@for='WALLETOTHERS']//div[@class='_1XFPmK']")
	private WebElement paymentOptions;
	
	By mobileLink = By.xpath("//label[@class='_1fqY3P']/span");
	By passwordLink = By.xpath("//label[@class='_1fqY3P']");
	By orderSummaryBtn = By.xpath("//button[text()='CONTINUE']");
	By placeOrderLink = By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']");
	By paymentOptionsLink = By.xpath("//label[@for='WALLETOTHERS']//div[@class='_1XFPmK']");
	

	
	
	

	public void verifyIsProductAddToCart() {
		String crtno = getElementText(myCartnumber);
		System.out.println("my cart number "+crtno);
		Assert.assertEquals(crtno,ReadProp.readData("Config.properties").getProperty("cartNumber"));
		logInfo("Product is added to cart");
		
	}

	
	public void verifyProductName() {
		String Product = getElementText(productNameSelected);
		Assert.assertEquals(Product,ReadProp.readData("Config.properties").getProperty("productname"));
		System.out.println(Product);
		logInfo("Selected product name is diplaying in cart");

	}
	
	
	public void PlaceOrder(String Email,String Password)
	{
		

		click(placeOrder);
		enterInfo(email,Email);
		click(continueBtn);
		
		waitForElement(mobileLink);

		
		enterInfo(mobile,"");
		

		click(continueBtn);
		
		waitForElement(passwordLink);
		
		enterInfo(password,Password);

		click(login);
		
			
		waitForElement(orderSummaryBtn);
		
		click(orderSummary);
		
		
		waitForElement(paymentOptionsLink);

		jsClick(paymentOptions);
		
		

	}

	
	public static SecurePayment getSecurePaymentPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), SecurePayment.class);
	}

}
