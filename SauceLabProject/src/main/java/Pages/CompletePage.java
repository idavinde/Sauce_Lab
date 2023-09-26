package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage extends BasePage {

	
	
public  CompletePage(WebDriver driver) {
		
	super(driver);
	}

	@FindBy(xpath="//h2")
	private WebElement Thnkyou;
	
	@FindBy(id="back-to-products")
	private WebElement backToHome;
	
	public String getHeaderText() {
		
		return Thnkyou.getText();
	}
	
	public void clickToHome() {
		
		clickElement(backToHome);
	}

}
