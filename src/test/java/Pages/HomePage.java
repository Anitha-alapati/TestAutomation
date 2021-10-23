package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	
WebDriver driver;
	
	By Category = By.xpath("//a[@class='envo-categories-menu-first']");
	By Cookies = By.xpath("//a[text()='Accept all']");
	By clothing = By.xpath("//a[@title='Clothing']");
	By AllPrcts = By.xpath("//ul[@class='products columns-4']/li/a/h2");
	By AllWishLi = By.xpath("//ul[@class='products columns-4']/li/div/div[2]/div/div/a");
	By GoWishList = By.xpath("(//a[@title='Wishlist'])[1]");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	

	public void NavigatetoURL(String sURL) {
		driver.get(sURL);
		driver.manage().window().maximize();	
	}
	
	public void AcceptCookies() {
		driver.findElement(Cookies).click();
		
	}
	
	
	public void SelectClothingCategory() {		
		//hoverover
		WebElement element = driver.findElement(Category);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		
		//click clothing
		driver.findElement(clothing).click();
			
	}
	

	public void addProdsToWishList() throws Exception {
		
		List<WebElement> AllProducts = driver.findElements(AllPrcts);
		List<WebElement> AllWishLists = driver.findElements(AllWishLi);
		System.out.println(AllProducts.size()+" - size of elements");
		if(AllProducts.size()!=0) {
			
			System.out.println(AllProducts.get(0).getText());			
			System.out.println(AllProducts.get(2).getText());
			System.out.println(AllProducts.get(3).getText());
			System.out.println(AllProducts.get(6).getText());
						
			Thread.sleep(3000);
			AllWishLists.get(0).click();
			Thread.sleep(1000);
			AllWishLists.get(2).click();
			Thread.sleep(1000);
			AllWishLists.get(3).click();
			Thread.sleep(1000);
			AllWishLists.get(6).click();
		}

	}
	
	public void GotoWishList() {
		driver.findElement(GoWishList).click();
	}

}
