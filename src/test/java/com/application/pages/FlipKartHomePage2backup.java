package com.application.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.commons.WebCommons;
import com.framework.utils.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class FlipKartHomePage2backup extends WebCommons{
	
	//Login Page Elements
	
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	private WebElement searchProduct;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//div[class='_30jeq3']")
	private WebElement productprice;
		
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement loginPopup;
	
	@FindBy(xpath="//a[@title='MICIO Lucious Lips']")
	private WebElement selectedItem;

	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='_3g_HeN']")
	private WebElement myCartnumber;
	
	@FindBy(xpath="//span[@class='_2-ut7f _1WpvJ7']")
	private WebElement productPriceInCart;
	
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
	private WebElement productNameSelected;

	
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
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement placefinalOrder;

	
	
	@FindBy(xpath="//button[@class='_2KpZ6l _1seccl _3AWRsL']")
	private WebElement orderSummary;
	
	//@FindBy(xpath="//label[@class='_2Fn-Ln _30jOKh _2KEUG6 _18Z3T6 _3L7Pww']/input")
	@FindBy(xpath="//label[@for='WALLETOTHERS']//div[1]")
	private WebElement paymentOptions;
	
	@FindBy(xpath="//a[@class='_3SkBxJ']")
	private WebElement cart;

	
	@FindBy(xpath="//div[@class='_10vWcL td-FUv WDiNrH']/div[2]")
	private WebElement removeorder;
	
	@FindBy(xpath="//div[@class='td-FUv WDiNrH']/div[2]")
	private WebElement removeItemBtn;
	
	@FindBy(xpath="//div[text()='Your cart is empty!']")
	private WebElement cartEmpty;

	





	By mobileLink = By.xpath("//label[@class='_1fqY3P']/span");
	By passwordLink = By.xpath("//label[@class='_1fqY3P']");
	By selectedItemLink = By.xpath("//a[@title='MICIO Lucious Lips']");
	By placeOrderLink = By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']");
	By placeFinalOrderLink = By.xpath("//span[text()='Place Order']");
	By orderSummaryBtn = By.xpath("//button[text()='CONTINUE']");
	By paymentOptionsBtn =By.xpath("//label[@for='WALLETOTHERS']//div[1]");
	By removeLink =By.xpath("//div[@class='_10vWcL td-FUv WDiNrH']/div[2]");
	By removeItem = By.xpath("//div[@class='td-FUv WDiNrH']/div[2]");
	By cartText = By.xpath("//a[@class='_3SkBxJ']//span");
	By emptyCartText = By.xpath("//div[text()='Your cart is empty!']");
	

	
	
	//Login Page Actions
	
	public void launchApplication() {
		driver.get(ReadProp.readData("Config.properties").getProperty("url"));
		logInfo("Application successfully Launched");
	}
	
	public void verifyTitle() {
		Assert.assertEquals(ReadProp.readData("Config.properties").getProperty("title"), getPageTitle());
		logInfo("Application title is matching");

	}
	
	public void addProductTOCart()
	{
		jsClick(loginPopup);
		enterInfo(searchProduct,"MICIO Lucious Lips");
		click(searchBtn);
		//div[class='_30jeq3']
		waitForElement(selectedItemLink);
		jsClick(selectedItem);
        List<String> windows = new ArrayList<String>(driver.getWindowHandles());
        
        driver.switchTo().window(windows.get(1));//Child

		click(addToCartBtn);
		waitForElement(placeOrderLink);
		
		
		
		String crtno = getElementText(myCartnumber);
		
		System.out.println(crtno);
		
		if(crtno.equalsIgnoreCase("My Cart (1)"))
		{
			logInfo("Added item to the cart");

		}
		else
		{
			logInfo("Item not added to the cart");

		}
		
		String Product = getElementText(productNameSelected);
		
		System.out.println(Product);

		
		if(Product.equalsIgnoreCase("MICIO Lucious Lips"))
		{
			logInfo("Selected productName is added to the cart");

		}else {
			logInfo("productName is not matching");
		}
	
		/*
		 * String productRate = getElementText(productprice);
		 * 
		 * System.out.println(productRate); String productRateInCart =
		 * getElementText(productPriceInCart);
		 * 
		 * System.out.println(productRateInCart);
		 * 
		 * 
		 * if(productRate.equals(productRateInCart)) {
		 * logInfo("Right product is added with the correct prices");
		 * 
		 * }else { logInfo("Prices are not matching");
		 * 
		 * }
		 */		

		click(placeOrder);
		enterInfo(email,"lavanya.ibo@gmail.com");
		
		click(continueBtn);
		
		waitForElement(mobileLink);

		
		enterInfo(mobile,"8074195553");
		click(continueBtn);
		
		waitForElement(passwordLink);
		
		enterInfo(password,"Lavanya19");
		click(login);
		
		//waitForElement(placeFinalOrderLink);

		//click(placefinalOrder);
		
		waitForElement(orderSummaryBtn);
		
		click(orderSummary);
		
	//	waitForElement(paymentOptionsBtn);
		
	//	selectCheckbox(paymentOptions);

		
        driver.switchTo().window(windows.get(0));//parent
        
        waitForElement(cartText);
		
		click(cart);
		

        waitForElement(removeLink);
		
		click(removeorder);
		
		
		 waitForElement(removeItem);
			
			jsClick(removeItemBtn);
			
			waitForElement(emptyCartText);	

			String emptymsg = getElementText(cartEmpty);
			
			System.out.println(emptymsg);
			
			if(emptymsg.equalsIgnoreCase("Your cart is empty!"))
			{
				logInfo("Items Removed in the cart Succesfully");

			}
			else
			{
				logInfo("Items are not Removed in the cart");

			}

			
		

		
		
		
		
	}
	
	

		
	public static FlipKartHomePage2backup getHomePage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), FlipKartHomePage2backup.class);
	}
}
