package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ReadConfig;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "item_4_title_link")
	private WebElement backpack;

	@FindBy(xpath = "//div[@class =\"pricebar\" ]/div[1]")
	private WebElement price;

	@FindBy(xpath = "//div[contains(text(),\"Sauce Labs Fleece\")]")
	private WebElement jacket;

	@FindBy(className = "product_sort_container")
	private WebElement dropbox;

	@FindBy(className="btn_inventory")
	private List<WebElement> addToCartBtns;
	
	

	public String getbackPackPrice() {

		return price.getText();
	}

	public void clickBackPack() {

		clickElement(backpack);
	}

	public void clickJacket() {
		clickElement(jacket);
		
	}

	public void selectDropbox(int x) {
		selectByIndex(dropbox, x);
	}

	public List<WebElement> getInventoryItem(int x) {

		if (x < 2) {

			return commonItemNameOnPage();
		}

		else {

			return commonItemPriceOnPage();
		}
	}

	public List<String> getItemName(int x) throws IOException {
		
		List<String> ItemName;
		ItemName = conversionToListString(new ReadConfig().getItemList());
		
		
		if (x==0)
			Collections.sort(ItemName);

		else
			Collections.sort(ItemName, Collections.reverseOrder());

		return ItemName;

	}

	public List<Float> getItemPrice(int x) throws IOException {
		
		List<Float> itemPrice;
		itemPrice = conversionToListFloat(new ReadConfig().getItemPriceList());


		if (x == 2) {
			Collections.sort(itemPrice);
		}

		else {
			Collections.sort(itemPrice, Collections.reverseOrder());
		}

		return itemPrice;
	}
	
	public void addToCartBtn(){
		
		for(int i=0;i<addToCartBtns.size();i++)
			clickElement(addToCartBtns.get(i));
		
	}
	
	public String getCartBadge() {
		
		return getText(commonShoppingBadge());
	}
}

