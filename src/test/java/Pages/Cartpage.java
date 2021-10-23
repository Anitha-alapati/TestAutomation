package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cartpage {
	
	WebDriver driver;
	
	By MyCartPage = By.xpath("//table/tbody/tr/td[@class='product-remove']");
	
	public Cartpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ValidateMycartPage() {
		List<WebElement>allItemsCart = driver.findElements(MyCartPage);
		if(allItemsCart.size()==1) {
			System.out.println("Item displaying in the cart");
		}
		
	}

}
