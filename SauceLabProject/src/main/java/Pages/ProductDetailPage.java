package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {
	
	
	
	
public ProductDetailPage(WebDriver driver) {
		
	 super(driver);
	}
	
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	private WebElement addToCart;
	
	@FindBy(xpath="//div[contains(@class,\"details_desc \")]")
	private WebElement description;
	
	
	
	public void clickAddToCart() {
		
		clickElement(addToCart);
		
	}
	
	public String getTextDescription() {
		
		return getText(description);
	}
	
	
	
}
