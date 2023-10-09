package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.LoginPage;


public class BrowserLaunch {

WebDriver driver;
public static Logger logger;

	
	@BeforeClass
	public void setUp() throws IOException {
		logger = Logger.getLogger("SauceLab");
		PropertyConfigurator.configure("Log4j.properties");
		ChromeOptions co = new ChromeOptions();
		co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chromedriver.driver", "/Users/honey/Desktop/chromedriver");
		driver = new ChromeDriver(co);
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
		logger.info("username Enter");
		new LoginPage(driver).enterUsername(user);
		logger.info("Password Enter");
		new LoginPage(driver).enterPassword(pass);
		logger.info("Click Submit Button");
		new LoginPage(driver).clickButton();
		
	}
	
	public void clearDataAndError() {
		new LoginPage(driver).clearElements();
		new LoginPage(driver).clickErrorBtn();
		
	}
	
	public void commonlogout() {
		new LoginPage(driver).clickBurgerBtn();
		new LoginPage(driver).clickLogoutBtn();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
