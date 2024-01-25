package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.InfoPage;
import Pages.ProductPage;
import Utility.ReadConfig;

public class InfoPageTestCases extends BrowserLaunch {
	
	@Test(priority = 1)
	public void CartPageLogin() throws IOException, InterruptedException {
		
		LoginPage(new ReadConfig().getUsername(),new ReadConfig().getPassword(),driver);
		
		logger.info("Item added to Cart");
		new ProductPage(driver).addToCartBtn();
		
		logger.info("Click on shopping cart");
		new ProductPage(driver).clickShoppingBag();
		
		logger.info("Click on Checkout");
		new CartPage(driver).clickCheckout();
		
		
		
	}
	
	
	
	
	@Test(priority = 2, dependsOnMethods= {"CartPageLogin"})
	public void enterDetailWithoutFN() throws IOException, InterruptedException {
		
		
		new InfoPage(driver).enterlastName(new ReadConfig().getLastName());
		new InfoPage(driver).enterPostalCode(new ReadConfig().getPostalCode());
		
		new InfoPage(driver).clickContinueBtn();
		logger.info("FN error Verified");
		Assert.assertEquals( new InfoPage(driver).getErrorMsg(), "Error: First Name is required");
		

		
		driver.navigate().refresh();
		
	}
	
	@Test(priority = 3, dependsOnMethods= {"enterDetailWithoutFN"})
	public void enterDetailWithoutLN() throws IOException, InterruptedException {
		
		
		
		logger.info("FN enter");
		new InfoPage(driver).enterfirstName(new ReadConfig().getFirstName());
		
		logger.info("PC enter");
		new InfoPage(driver).enterPostalCode(new ReadConfig().getPostalCode());
		Thread.sleep(4000);
		
		logger.info("click on continue");
		new InfoPage(driver).clickContinueBtn();
		
		Assert.assertEquals( new InfoPage(driver).getErrorMsg(), "Error: Last Name is required");

		
		driver.navigate().refresh();
		
	}
	
	@Test(priority = 4, dependsOnMethods= {"enterDetailWithoutLN"},enabled=true)
	public void enterDetailWithoutPC() throws IOException {
		
		new InfoPage(driver).enterfirstName(new ReadConfig().getFirstName());
		new InfoPage(driver).enterlastName(new ReadConfig().getLastName());
		
		new InfoPage(driver).clickContinueBtn();
		
		Assert.assertEquals( new InfoPage(driver).getErrorMsg(), "Error: Postal Code is required");

		driver.navigate().refresh();
	
	}
	
	
	@Test(priority = 5, dependsOnMethods= {"enterDetailWithoutPC"}, enabled=true)
	public void enterValidUserDetail() throws IOException {
		
		new InfoPage(driver).enterfirstName(new ReadConfig().getFirstName());
		new InfoPage(driver).enterlastName(new ReadConfig().getLastName());
		new InfoPage(driver).enterPostalCode(new ReadConfig().getPostalCode());
		new InfoPage(driver).clickContinueBtn();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
		
		driver.navigate().back();
		
	}

}
