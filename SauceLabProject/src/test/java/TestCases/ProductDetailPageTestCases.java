package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.ProductPage;
import Utility.ReadConfig;

public class ProductDetailPageTestCases extends BrowserLaunch {
	
	@Test
	public void loginAndSelectItems() throws IOException, InterruptedException {
		
		driver.manage().deleteAllCookies();
		
		
		Thread.sleep(4000);
	}

}
