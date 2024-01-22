package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Comparator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class BasePage extends CommonElement {

	WebDriver driver;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElemnetVisibility(WebElement e) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(e));

	}
	

	public void sendKey(WebElement e, String text) {

		waitForElemnetVisibility(e);
		e.sendKeys(text);

	}

	public void clickElement(WebElement e) {
		waitForElemnetVisibility(e);
		e.click();
	}

	public void clearElement(WebElement e) {
		waitForElemnetVisibility(e);
		e.clear();
	}

	public String getText(WebElement e) {
		waitForElemnetVisibility(e);
		return e.getText();

	}

	public void selectByIndex(WebElement e, int x) {
		waitForElemnetVisibility(e);
		Select s = new Select(e);
		s.selectByIndex(x);

	}
	
	public boolean isElementPresent(WebElement f) {
	    try {
	        // Set a short implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	        return f.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    } finally {
	        // Reset the implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    }
	}
	
	public void scrollDown( WebElement e) {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
	}
	

	public void selectByvisibleText() {
	}

	public void selectByValue() {
	}

	public void clickAlert() {

		Alert al = driver.switchTo().alert();
		al.accept();

	}

	public void clickShoppingBag() {
		
		clickElement(commonShoppingBag());	
		
	}
	
	public void clickRemoveBtn() {

		clickElement(commonRemoveBtn());
	}
	
	public List<Float> conversionToListFloat(String[] s) {

		List<Float> string = new ArrayList<Float>();

		for (int i = 0; i < s.length; i++) {
			string.add(Float.parseFloat(s[i]));

		}
		return string;
	}

	public List<String> conversionToListString(String[] s) {
		
		List<String> string = new ArrayList<String>();

		for (int i = 0; i < s.length; i++) {
			string.add(s[i]);

		}
		return string;
	}

	public String getPageTitles() {
		return getText(getPageTitle());
	}

	public void clickBurgerBtn() {
		clickElement(commonBurgerBtn());
	}

	public void clickLogoutBtn() {
		clickElement(commonLogoutBtn());
	}
	
	public void clickfb() {
		scrollDown(facebookBtn());
		clickElement(facebookBtn());
	}

	public void clicklinkedin() {

		clickElement(linkedinBtn());
	}

	public void clicktwitter() {

		clickElement(twitterBtn());
	}
	
	public void shiftToNewTab(String link) {
		
		ArrayList<String> arr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(arr.get(1));
		Assert.assertEquals(driver.getCurrentUrl(),link);
		driver.close();
		driver.switchTo().window(arr.get(0));
		
	}
	
	public String getFooterLinkText() {
		
		return getText(footerLink());
	}
	
	public String getMainLogoText() {
		scrollDown(mainLogo());
		return getText(mainLogo());
	}
	
	public void selectTextAndLinks() {
		
		new BasePage(driver).clickfb(); 
		//logger.info("Click on Facebook link");
		new BasePage(driver).shiftToNewTab("https://www.facebook.com/saucelabs");
	
		new BasePage(driver).clicklinkedin();
		//logger.info("Click on Linkedin link");
		new BasePage(driver).shiftToNewTab("https://www.linkedin.com/company/sauce-labs/");
		
		new BasePage(driver).clicktwitter();
		//logger.info("Click on Twitter link");
		new BasePage(driver).shiftToNewTab("https://twitter.com/saucelabs");
		
		//logger.info("Check footer text");
		Assert.assertEquals(new BasePage(driver).getFooterLinkText(), "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
		
		//logger.info("Check Main Logo text");
		Assert.assertEquals(new BasePage(driver).getMainLogoText(), "Swag Labs");
	}
	
	
	public void commonAbout() {
		new BasePage(driver).clickBurgerBtn();
		
		Assert.assertTrue(getCrossBtn().isEnabled());
		new BasePage(driver).clickElement(getAboutLink());
		Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
		driver.navigate().back();
	}
	
	public void commonLogout() {
		
		new BasePage(driver).clickBurgerBtn();
		new BasePage(driver).clickLogoutBtn();
		
	}
	
	public void commonAllItems(){
		new BasePage(driver).clickBurgerBtn();
		new BasePage(driver).clickElement(getAllItemBtn());
		new BasePage(driver).clickElement(getCrossBtn());
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		
	}
	
	public void commonReset() {
		String a;
		if(isElementPresent(commonShoppingBadge()))
		{
			//a = commonShoppingBadge().getText();
			new BasePage(driver).clickBurgerBtn();
			new BasePage(driver).clickElement(getResetBtn());
			new BasePage(driver).clickElement(getCrossBtn());
			
			Assert.assertFalse(isElementPresent(commonShoppingBadge()));
		}
		
	}
	
	public void burgerBtn() {
		commonAbout();
		commonAllItems();
		commonReset();
		commonLogout();
	}
	
	
	
	
}
