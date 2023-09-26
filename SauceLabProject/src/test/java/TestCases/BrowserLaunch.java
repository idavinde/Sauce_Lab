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


	
	@BeforeClass
	
	public void setUp() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	}
	
	
	
	
	@AfterClass
	public void done() {
		
		driver.quit();
	}
	
	public void LoginPage(String user ,String pass,WebDriver driver) 
	{
		
		new LoginPage(driver).enterUsername(user);
		new LoginPage(driver).enterPassword(pass);
		new LoginPage(driver).clickButton();
	}
	
	public void clearDataAndError() {
		new LoginPage(driver).clickErrorBtn();
		new LoginPage(driver).clearElements();
	}
}
