package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

	@Test(enabled = false,priority = 1)
	public void enterValidUsernameAndPassword() throws IOException, InterruptedException {
		// Entered valid Username and Password
		new LoginPage(driver).enterUsername(new ReadConfig().getUsername());
		new LoginPage(driver).enterPassword(new ReadConfig().getPassword());
		 new LoginPage(driver).clickButton();
		 String text = new BasePage(driver).getPageTitles();
		Assert.assertEquals(text, "Products");
		Thread.sleep(2000);

	}

	@Test(enabled = false, priority = 2)
	public void EndToEndFlow() throws IOException, InterruptedException {

		// Choosing item from Product Page
		new ProductPage(driver).clickJacket();
		//Verify the page title of Product detail 
		String des = new ProductDetailPage(driver).getTextDescription();
		Assert.assertEquals(des,"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
		// Add to cart product
		new ProductDetailPage(driver).clickAddToCart();
		// open Cart page
		new ProductDetailPage(driver).clickShoppingBag();
		//Verify cart Page
		String title = new CartPage(driver).getPageTitles();
		Assert.assertEquals(title, "Your Cart");
		
		new CartPage(driver).clickCheckout();
		//Verify Information Page
		title = new InfoPage(driver).getPageTitles();
		Assert.assertEquals(title, "Checkout: Your Information");
		// Enter FirstName, LastName and PostalCode
		new InfoPage(driver).enterfirstName(new ReadConfig().getFirstName());
		new InfoPage(driver).enterlastName(new ReadConfig().getLastName());
		new InfoPage(driver).enterPostalCode(new ReadConfig().getPostalCode());
		new InfoPage(driver).clickContinueBtn();
		//Verify OverviewPage
		title = new OverviewPage(driver).getPageTitles();
		Assert.assertEquals(title, "Checkout: Overview");
		// Click Finish Button
		new OverviewPage(driver).clickFinish();
		//Verify Complete Page and thank you message
		title = new CompletePage(driver).getPageTitles();
		Assert.assertEquals(title, "Checkout: Complete!");
		title = new CompletePage(driver).getHeaderText();
		Assert.assertEquals(title, "Thank you for your order!");
		new CompletePage(driver).clickToHome();
		
		//Logout from Product Page
		new ProductPage(driver).clickBurgerBtn();
		new ProductPage(driver).clickLogoutBtn();
		Thread.sleep(2000);

	}
	
	@Test(enabled = false, priority = 3)
	public void BlankUserAndBlankPass() throws InterruptedException {
		
		Thread.sleep(5000);
		new LoginPage(driver).clickButton();
		String error = new LoginPage(driver).getErrorMessage();
		Assert.assertEquals(error, "Epic sadface: Username is required");
		new LoginPage(driver).clickErrorBtn();

	}

	@Test(enabled = false , priority = 4)
	public void InvalidUserAndValidPass() throws IOException, InterruptedException {

		new LoginPage(driver).enterUsername(new ReadConfig().getWrongUsername());
		new LoginPage(driver).enterPassword(new ReadConfig().getPassword());
		new LoginPage(driver).clickButton();
		String error = new LoginPage(driver).getErrorMessage();
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
		
		new LoginPage(driver).clickErrorBtn();
		new LoginPage(driver).clearElements();
		Thread.sleep(2000);

	}

	@Test(enabled = false, priority = 5)
	public void validUserAndInvalidPass() throws IOException, InterruptedException {

		new LoginPage(driver).enterUsername(new ReadConfig().getUsername());
		new LoginPage(driver).enterPassword(new ReadConfig().getWrongPassword());
		new LoginPage(driver).clickButton();
		
		String error = new LoginPage(driver).getErrorMessage();
		
		
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
		
		new LoginPage(driver).clickErrorBtn();
		new LoginPage(driver).clearElements();
		
	}

	@Test(enabled = false, priority = 6)
	public void InvalidUserAndInvalidPass() throws IOException, InterruptedException {
		
		
		Thread.sleep(5000);
		new LoginPage(driver).enterUsername(new ReadConfig().getWrongUsername());
		new LoginPage(driver).enterPassword(new ReadConfig().getWrongPassword());
		new LoginPage(driver).clickButton();
		String error = new LoginPage(driver).getErrorMessage();
		Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
		
		new LoginPage(driver).clickErrorBtn();
		new LoginPage(driver).clearElements();
		
		
	}
	
	
	@Test (priority = 7)
	public void  assign() throws InterruptedException {
		
	//First Solution
//		new LoginPage(driver).clickElement(driver.findElement(By.linkText("Click Here")));
//		Thread.sleep(3000);
//		Set<String> windowHandel = driver.getWindowHandles();
//		String a = (String)windowHandel.toArray()[0];
//		String b = (String)windowHandel.toArray()[1];
//		driver.switchTo().window(b);
//		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		
		//Second Solution
//	WebElement e= 	driver.findElement(By.xpath("//div[2][@class=\"figure\"]"));
//		Actions action  = new Actions(driver);
//		action.moveToElement(e).perform();
//		Thread.sleep(10000);
//		String c= driver.findElement(By.xpath("//a[@href=\"/users/2\"]/preceding-sibling::h5")).getText();
//		Assert.assertEquals(c,"name: user2");
		WebElement e= 	driver.findElement(By.xpath("//button[text() =\"Remove\"]"));
		e.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOf(e));
	        
	        boolean isRemoveButtonPresent = driver.findElements(By.cssSelector("#button")).size() > 0;
	        if(!isRemoveButtonPresent) {
	            System.out.println("Remove Button is not present. Verification successful!");
	        } else {
	            System.out.println("Remove Button is still present. Verification failed!");
	        }
	        
		if(!e.isDisplayed()) {
			System.out.println("yes");
		}
		
		
//		for(int i=0;i<e.size();i++) {
//		if(e.get(i).isSelected())
//		{ e.get(i).click();}
//		}
//		
	}
	@Test
	public void boxFunction(WebElement e) {
		 Actions ac =new Actions(driver);
		 ac.click(e);
		}

}
