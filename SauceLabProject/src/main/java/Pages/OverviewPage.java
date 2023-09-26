package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BasePage {
	
	
public  OverviewPage(WebDriver driver) {
		
	super(driver);
	}
	@FindBy(id="finish")
	private WebElement finish;
	
	public void clickFinish()
	{
		clickElement(finish);
	}
}
