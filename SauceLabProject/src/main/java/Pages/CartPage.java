package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ReadConfig;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "checkout")
	private static WebElement checkout;
	
	@FindBy(id="continue-shopping")
	private WebElement continueShopping;

	public void clickCheckout() {

		clickElement(checkout);
	}
	
	public void clickContinue() {
		//scrollDown(continueShopping );
		clickElement(continueShopping);
	}

	public List<WebElement> getItemNameOnPage() {

		return commonItemNameOnPage();
	}

	public List<WebElement> getItemPriceOnPage() {

		return commonItemPriceOnPage();
	}
	
	public List<String> getNameToCompare() throws IOException {
		List<String> ItemName;
		
		 ItemName = conversionToListString(new ReadConfig().getItemList());
		 return ItemName;
	}
	
	public List<String> getPriceToCompare() throws IOException {
		List<String> ItemName;
		
		 ItemName = conversionToListString(new ReadConfig().getItemPriceList());
		 return ItemName;
	}
}
