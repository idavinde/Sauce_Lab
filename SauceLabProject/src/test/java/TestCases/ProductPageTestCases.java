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
		new ProductPage(driver).selectTextAndLinks();
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
			
			Thread.sleep(4000);
		}

	}
	
	@Test(enabled = true, priority=2, dependsOnMethods="selectingDropboxOption")
	public void addToCartMutipleItems() throws InterruptedException, IOException {
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
