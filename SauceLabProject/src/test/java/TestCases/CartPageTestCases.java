package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ProductPage;
import Utility.ReadConfig;


public class CartPageTestCases extends BrowserLaunch {
	
	@Test
	public void verifyAddedItems() throws InterruptedException, IOException {
		
		LoginPage(new ReadConfig().getUsername(),new ReadConfig().getPassword(),driver);
		
		
		
		logger.info("Items added to the cart");
		new ProductPage(driver).addToCartBtn();
		
		logger.info("Click on shopping Cart");
		new ProductPage(driver).clickShoppingBag();
		
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
		new CartPage(driver).selectTextAndLinks();
		
		//new CartPage(driver).clickContinue();
		
		
	}
	
	@Test(priority=2,dependsOnMethods="verifyAddedItems")
	public void burgerBtn() {
		
		logger.info("Click on All Items");
		new ProductPage(driver).commonAllItems(driver);
		
		new ProductPage(driver).clickShoppingBag();
		
		logger.info("Click on Reset");
		new ProductPage(driver).commonReset();
		logger.info("Click on About");
		new ProductPage(driver).commonAbout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		logger.info("Click on logout");
		
		new ProductPage(driver).commonLogout(driver);
		
	}

	

}
