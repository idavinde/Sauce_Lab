package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	
}
