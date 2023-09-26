package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPage extends BasePage {
	
	
public  InfoPage(WebDriver driver) {
		
	super(driver);
	}
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postalCode;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	public void enterfirstName(String str) {
		sendKey(firstName,str);
	}
	
	public void enterlastName(String str) {
		sendKey(lastName,str);
	}
	
	public void enterPostalCode(String str) {
		sendKey(postalCode,str);
	}
	
	public void clickContinueBtn() {
		
		clickElement(continueBtn);
	}
	
	
}
