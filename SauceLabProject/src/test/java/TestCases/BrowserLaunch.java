package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CompletePage;
import Pages.InfoPage;
import Pages.LoginPage;
import Pages.OverviewPage;
import Pages.ProductDetailPage;
import Utility.ReadConfig;

public class BrowserLaunch {

WebDriver driver;

protected LoginPage loginPage  ;
ProductDetailPage productDetailPage = new ProductDetailPage(driver);
CartPage cartPage =new CartPage(driver);
InfoPage infoPage =new InfoPage(driver);
OverviewPage overviewPage =new OverviewPage(driver);
CompletePage completePage=new CompletePage(driver);
ReadConfig readConfig;

	
	@BeforeClass
	@Test
	public void setUp() throws IOException {
		driver = new ChromeDriver();
		setdriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	}
	
	
	@Test(dependsOnMethods= {"setUp"})
	public void setdriver() throws IOException {
		
		loginPage  = new LoginPage(driver);
	    readConfig = new ReadConfig();
	    
	}
	
	@AfterClass
	public void done() {
		
		driver.quit();
	}
	
	public void LoginPage(String user ,String pass) 
	{
		
		loginPage.enterUsername(user);
		loginPage.enterPassword(pass);
		loginPage.clickButton();
	}
	
	public void clearDataAndError() {
		loginPage.clickErrorBtn();
		loginPage.clearElements();
	}
}
