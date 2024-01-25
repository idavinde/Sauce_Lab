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
	
	@FindBy(xpath="//h3[@data-test=\"error\"]")
	private WebElement errorMsg;
	
	@FindBy(className="error-button")
	private WebElement errorBtn;
	
	
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
	
	public String getErrorMsg() {
		
		return getText(errorMsg);
	}
	
public void clickOnErrorMsg() {
		
		 clickElement(errorBtn);
	}

	
public void clearElements() {
		//clickElement(firstName);
		clearElement(firstName);
		//clickElement(lastName);
		clearElement(lastName);
		//clickElement(postalCode);
		clearElement(postalCode);
}
public void clearLN() {
	deleteText(lastName);
}

public void clearPC() {
	deleteText(postalCode);
}
	
}
