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

public class FlipKartHomePage extends WebCommons{
	
	 public List<String> windows ;
	
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
	
	@FindBy(xpath="//span[@class='_2-ut7f _1WpvJ7']")
	private WebElement productPriceInCart;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement placefinalOrder;

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

	
	By selectedItemLink = By.xpath("//a[@title='MICIO Lucious Lips']");
	By placeOrderLink = By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']");
	By placeFinalOrderLink = By.xpath("//span[text()='Place Order']");
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
		enterInfo(searchProduct,ReadProp.readData("Config.properties").getProperty("productname"));
		click(searchBtn);
		waitForElement(selectedItemLink);
		jsClick(selectedItem);
		 windows = new ArrayList<String>(driver.getWindowHandles()); 
        
        driver.switchTo().window(windows.get(1));//Child
        System.out.println(addToCartBtn.getText());
		click(addToCartBtn);
		waitForElement(placeOrderLink);
		
	}	
				
		
	public void removeProduct()
	{
        driver.switchTo().window(windows.get(0));//parent
        
        waitForElement(cartText);
		click(cart);
		
     waitForElement(removeLink);
	click(removeorder);
		
	 waitForElement(removeItem);

	jsClick(removeItemBtn);
			
	waitForElement(emptyCartText);	

			String emptymsg = getElementText(cartEmpty);
			Assert.assertEquals(emptymsg,ReadProp.readData("Config.properties").getProperty("cartemptymsg"));
			System.out.println(emptymsg);
			logInfo("Items Removed in the cart Succesfully");
	
			
		
	}
	
	

		
	public static FlipKartHomePage getHomePage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), FlipKartHomePage.class);
	}
}
