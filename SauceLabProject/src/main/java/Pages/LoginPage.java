package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	// 1. PageElement
	//2. Page Actions
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//h3")
	private WebElement errorMsg;
	
	@FindBy(xpath="//button[@class=\"error-button\"]")
	private WebElement errorBtn;
	
	
	public void enterUsername(String str){
		
		sendKey(username,str);
	}
	
	public void enterPassword(String str) {
		
		sendKey(password,str);
	}
	
	public void clickButton() {
		
		clickElement(loginBtn);
	
	}
	
	public String getErrorMessage() {
		
		return getText(errorMsg);
	}
	
	public void clearElements() {
		clickElement(username);
		clearElement(username);
		clickElement(password);
		clearElement(password);
	}
	
	public void clickErrorBtn() {
		clickElement(errorBtn);
	}
	

}
