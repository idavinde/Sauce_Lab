package TestCases;

import java.io.IOException;
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

	@Test(description ="Login into Website Using Valid Username and Password",priority=1)
	public void loginWithUsernameAndPass() throws IOException {

		new LoginPage(driver).enterUsername(new ReadConfig().getUsername());
		new LoginPage(driver).enterPassword(new ReadConfig().getPassword());
		new LoginPage(driver).clickButton();

	}

	@Test(description = "Selecting the Item name AtoZ or ZtoA / Price LtoH or HtoL option from dropbox", enabled = true, priority=2)
	public void selectingDropboxOption() throws IOException, InterruptedException 
	{
		//Loop for number on items options in Dropbox
		for (int i = 0; i <= 3; i++)   //kkkii
		{
			// click on Dropbox
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
	
	@Test(priority=3)
	public void addToCartMutipleItems() throws InterruptedException, IOException {
		
		new ProductPage(driver).addToCartBtn();
		
		Assert.assertEquals(new ProductPage(driver).getCartBadge(), "6");
		
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
		
		
	}
	
	

}
