package TestCases;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.ProductPage;
import Utility.ReadConfig;

public class ProductPageTestCases extends BrowserLaunch {


	@Test(description = "Login and Selecting the Item name AtoZ or ZtoA / Price LtoH or HtoL option from dropbox", enabled = true, priority=1)
	public void selectingDropboxOption() throws IOException, InterruptedException 
	{
		LoginPage(new ReadConfig().getUsername(),new ReadConfig().getPassword(),driver);
		//Loop for number on items options in drop box
		logger.info("Click on dropbox and check all options");
		for (int i = 0; i <= 3; i++)   
		{
			// click on Drop box
			new ProductPage(driver).selectDropbox(i);
			
			//getting expected name of items 
			List<String> itemName = new ProductPage(driver).getItemName(i);
			
			//getting Expected price of items
			List<Float> itemPrice = new ProductPage(driver).getItemPrice(i);
			
			//getting List of Items actual names or Prices from page
			List<WebElement> s = new ProductPage(driver).getInventoryItem(i); 
			
			//Assertion for verifying the Name and Price of items
			for (int j = 0; j < s.size(); j++) 
			{
				if (i < 2)
					Assert.assertEquals(s.get(j).getText(), itemName.get(j));
				else
					Assert.assertEquals(s.get(j).getText(), "$" + itemPrice.get(j));

			}
		}

	}
	
	@Test(enabled = true, priority=3, dependsOnMethods="selectingDropboxOption")
	public void addToCartMutipleItems() throws InterruptedException, IOException {
		
		new ProductPage(driver).addToCartBtn();
		Assert.assertEquals(new ProductPage(driver).getCartBadge(),"6");
		
		new ProductPage(driver).clickShoppingBag();
		
		List<WebElement> itemName = new CartPage(driver).getItemNameOnPage();
		List<WebElement> itemPrice = new CartPage(driver).getItemPriceOnPage();
		List<String> itemNameCompare = new CartPage(driver).getNameToCompare();
		List<String> itemPriceCompare = new CartPage(driver).getPriceToCompare();
		
		
		for (int j = 0; j < itemName.size(); j++) 
		{		
			Assert.assertTrue(itemNameCompare.contains(itemName.get(j).getText()));
			Assert.assertTrue(itemPriceCompare.contains((itemPrice.get(j).getText()).substring(1)));
		}
		
		new CartPage(driver).clickContinue();
		new CartPage(driver).clickBurgerBtn();
		new CartPage(driver).clickLogoutBtn();
		
		Thread.sleep(10000);
		
		
		
	}
	
	@Test (priority = 2 , dependsOnMethods= "selectingDropboxOption")
	public void checkTextandLink() throws InterruptedException {
		
		new ProductPage(driver).clickfb(); 
		logger.info("Click on Facebook link");
		new ProductPage(driver).shiftToNewTab("https://www.facebook.com/saucelabs");
	
		new ProductPage(driver).clicklinkedin();
		logger.info("Click on Linkedin link");
		new ProductPage(driver).shiftToNewTab("https://www.linkedin.com/company/sauce-labs/");
		
		new ProductPage(driver).clicktwitter();
		logger.info("Click on Twitter link");
		new ProductPage(driver).shiftToNewTab("https://twitter.com/saucelabs");
		
		logger.info("Check footer text");
		Assert.assertEquals(new ProductPage(driver).getFooterLinkText(), "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
		
		logger.info("Check Main Logo text");
		Assert.assertEquals(new ProductPage(driver).getMainLogoText(), "Swag Labs");
		
	}
	
	
	
	
	
	

}
