package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElement {
	
	@FindBy(xpath="//div[@class=\"header_secondary_container\"]/span")
	private static WebElement pageTitle;
	
	@FindBy(id="react-burger-menu-btn")
	private static WebElement burgerBtn;
	
	@FindBy(id="logout_sidebar_link")
	private static WebElement logoutBtn;
	
	@FindBy(className = "inventory_item_name")
	private static List<WebElement> inventoryNameList;
	
	@FindBy(className = "inventory_item_price")
	private static List<WebElement> inventoryPriceList;
	
	@FindBy(className="shopping_cart_badge")
	private static WebElement shoppingCartBadge;
	
	@FindBy(className="shopping_cart_link")
	private static WebElement shoppingBag;
	
	@FindBy(name="remove-sauce-labs-backpack")
	private static WebElement removeBtn;
	
	@FindBy(className="social_facebook")
	private static WebElement facebook;
	
	@FindBy(className="social_linkedin")
	private static WebElement linkedin;
	
	@FindBy(className="social_twitter")
	private static WebElement twitter;
	
	@FindBy(css="div.footer_copy")
	private static WebElement footerLink;
	
	@FindBy(css="div.app_logo")
	private static WebElement mainLogo;
	
	@FindBy(id="about_sidebar_link")
	private static WebElement aboutLink;
	
	@FindBy(id="react-burger-cross-btn")
	private static WebElement crossButton;
	
	@FindBy(id="inventory_sidebar_link")
	private static WebElement allItemBtn;
	
	@FindBy(id="reset_sidebar_link")
	private static WebElement resetBtn;
	
	
	
	protected static WebElement getPageTitle() {
		
		return pageTitle;
	}
	
	protected static WebElement commonBurgerBtn() {

		return burgerBtn;
	}
	
	protected static WebElement commonLogoutBtn() {

		return logoutBtn;
	}
	
	protected static List<WebElement> commonItemNameOnPage(){
		
		return inventoryNameList;
	}
	
	protected static List<WebElement> commonItemPriceOnPage() {

		return inventoryPriceList;
	}
	
	protected static WebElement commonShoppingBadge() {

		return shoppingCartBadge;
	}
	
	protected static WebElement commonShoppingBag() {

		return shoppingBag;
	}
	
	protected static WebElement commonRemoveBtn() {

		return removeBtn;
	}
	
	protected static WebElement facebookBtn() {

		return facebook;
	}
	protected static WebElement linkedinBtn() {

		return linkedin;
	}
	protected static WebElement twitterBtn() {

		return twitter;
	}
	
	protected static WebElement footerLink() {
		
		return footerLink;
	}
	
	protected static WebElement mainLogo() {
		
		return  mainLogo;
	}
	
	protected static WebElement getAboutLink() {
		
		return aboutLink;
	}
	
	protected static WebElement getCrossBtn() {
		
		return crossButton;
	}
	
protected static WebElement getAllItemBtn() {
		
		return allItemBtn;
	}
	
protected static WebElement getResetBtn() {
	
	return resetBtn;
}
	
	
}
