package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage {
	
	WebDriver driver;
	int iWishlist = 0;
	
	By LiAllItems = By.xpath("//tbody[@class='wishlist-items-wrapper']/tr/td[3]/a");
	By LiAllPrices = By.xpath("//tbody[@class='wishlist-items-wrapper']/tr/td[4]/ins/span/bdi");
	By LiAllCarts = By.xpath("//table/tbody/tr/td[6]/a[contains(text(),'Add to cart')] ");
	By ItemsAddToCart = By.xpath("//tbody[@class='wishlist-items-wrapper']/tr/td[3]/a");
	By CartButton = By.xpath("(//a[@title='Cart'])[1]");
	
	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ValidateItemsWishList() {
		List<WebElement>allItems = driver.findElements(LiAllItems);
		System.out.println("total items displaying is - "+allItems.size());
		iWishlist = allItems.size();
		if(allItems.size()==4) {
			System.out.println("total items displaying is - 4");
		}
		System.out.println(allItems.get(0).getText());
		System.out.println(allItems.get(1).getText());
		System.out.println(allItems.get(2).getText());
		System.out.println(allItems.get(3).getText());
		
	}
	
	public void SelectLowestPriceProduct() {
		System.out.println("all item prices");
		int MinPrice = 0;
		int tIndex = 0;
		List<WebElement>allPrices = driver.findElements(LiAllPrices);
		List<WebElement>allCarts = driver.findElements(LiAllCarts);
		
		for(int i = 0;i<=allPrices.size()-1;i++) {
			Integer tempPrice = Integer.valueOf(allPrices.get(i).getText().replace("£", "").substring(0,2));
			
			if(i==0) {
				MinPrice=tempPrice;
			}
			if(tempPrice <= MinPrice) {
				MinPrice=tempPrice;
				tIndex = i;
			}
			
		}
		System.out.println("Min Price"+MinPrice );
		System.out.println("tIndex - "+tIndex );
		allCarts.get(tIndex).click();
	}
	
	public void VerifyItemAddedtoCart() {
		List<WebElement>allItems = driver.findElements(ItemsAddToCart);
		if(allItems.size()==(iWishlist-1)) {
			System.out.println("Item was removed from wishlist page");
		}	
	}
	
	public void ClickCartButton() throws Exception {
		Thread.sleep(3000);
		driver.findElement(CartButton).click();
	}

}
