package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.CartPage;
import Pages.CompletePage;
import Pages.InfoPage;
import Pages.LoginPage;
import Pages.OverviewPage;
import Pages.ProductDetailPage;
import Pages.ProductPage;
import Utility.ReadConfig;

public class LoginTestCases extends BrowserLaunch {
	
	@Test(enabled= true,priority = 1)
	public void enterValidUsernameAndPassword() throws IOException, InterruptedException {
		
		LoginPage(new ReadConfig().getUsername(), new ReadConfig().getPassword(), driver);
		
		String text;
		try {
		text= driver.getCurrentUrl();
		}
		catch(StaleElementReferenceException e) {
			text= driver.getCurrentUrl();
		}
		
		if(driver.getCurrentUrl().equals("https://www.ucedemo.com/inventory.html"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"enterValidUsernameAndPassword");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		

	}

	@Test(enabled= true,priority = 2)
	public void endToEndFlow() throws IOException, InterruptedException {

		// Choosing item from Product Page
		new ProductPage(driver).clickJacket();
		// Verify the page title of Product detail
		String des = new ProductDetailPage(driver).getTextDescription();
		Assert.assertEquals(des,
				"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
		// Add to cart product
		new ProductDetailPage(driver).clickAddToCart();
		// open Cart page
		new ProductDetailPage(driver).clickShoppingBag();
		// Verify cart Page
		String title = new CartPage(driver).getPageTitles();
		Assert.assertEquals(title, "Your Cart");

		new CartPage(driver).clickCheckout();
		// Verify Information Page
		title = new InfoPage(driver).getPageTitles();
		Assert.assertEquals(title, "Checkout: Your Information");
		// Enter FirstName, LastName and PostalCode
		new InfoPage(driver).enterfirstName(new ReadConfig().getFirstName());
		new InfoPage(driver).enterlastName(new ReadConfig().getLastName());
		new InfoPage(driver).enterPostalCode(new ReadConfig().getPostalCode());
		new InfoPage(driver).clickContinueBtn();
		// Verify OverviewPage
		title = new OverviewPage(driver).getPageTitles();
		Assert.assertEquals(title, "Checkout: Overview");
		// Click Finish Button
		new OverviewPage(driver).clickFinish();
		// Verify Complete Page and thank you message
		title = new CompletePage(driver).getPageTitles();
		Assert.assertEquals(title, "Checkout: Complete!");
		title = new CompletePage(driver).getHeaderText();
		Assert.assertEquals(title, "Thank you for your order!");
		new CompletePage(driver).clickToHome();

		// Logout from Product Page

		new LoginPage(driver).clickBurgerBtn();
		new LoginPage(driver).clickLogoutBtn();

	}

	@Test(priority=3, dependsOnMethods = {"endToEndFlow"} )
	public void BlankUserAndBlankPass() throws InterruptedException {
		
		new LoginPage(driver).clickButton();
		
		String error = new LoginPage(driver).getErrorMessage();
		Assert.assertEquals(error, "Epic sadface: Username is required");
		new LoginPage(driver).clickErrorBtn();

	}

	@Test(priority = 4, dependsOnMethods = {"BlankUserAndBlankPass"})
	public void InvalidUserAndValidPass() throws IOException, InterruptedException {

		LoginPage(new ReadConfig().getWrongUsername(), new ReadConfig().getPassword(), driver);

		String error = new LoginPage(driver).getErrorMessage();
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
		
		clearDataAndError();
		

	}

	@Test(priority = 5 , dependsOnMethods= {"InvalidUserAndValidPass"})
	public void validUserAndInvalidPass() throws IOException, InterruptedException {
		new LoginPage(driver).clearElements();
		LoginPage(new ReadConfig().getUsername(), new ReadConfig().getWrongPassword(), driver);
		String error = new LoginPage(driver).getErrorMessage();

		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");

		clearDataAndError();

	}

	@Test( priority = 6,dependsOnMethods= {"validUserAndInvalidPass"})
	public void InvalidUserAndInvalidPass() throws IOException, InterruptedException {

		
		new LoginPage(driver).clearElements();
		LoginPage(new ReadConfig().getWrongUsername(), new ReadConfig().getWrongPassword(), driver);

		String error = new LoginPage(driver).getErrorMessage();
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");

		clearDataAndError();

	}

}
