package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Cartpage;
import Pages.HomePage;
import Pages.WishListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleSteps {
	
	public WebDriver driver;
	
	
	public void fnLaunchBrowser() {		
		System.setProperty("webdriver.chrome.driver", "F:\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();			
	}
	
	@Given("I add four different products to my wish list")
	public void i_add_four_different_products_to_my_wish_list() throws Exception {
		fnLaunchBrowser();
		HomePage HomePage = new HomePage(driver);
		HomePage.NavigatetoURL("https://testscriptdemo.com/");
		HomePage.SelectClothingCategory();
		Thread.sleep(3000);
		HomePage.addProdsToWishList();
		HomePage.AcceptCookies();
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() {
		HomePage HomePage = new HomePage(driver);
		HomePage.GotoWishList();
	}
	
	@Then("I find total four selected items in my wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		WishListPage WishListPage = new WishListPage(driver);
		WishListPage.ValidateItemsWishList();
	}
	
	@When("I search for Lowest price product")
	public void i_search_for_lowest_price_product() {
	  System.out.println("Searching for the lowest price product");
		WishListPage WishListPage = new WishListPage(driver);
		WishListPage.SelectLowestPriceProduct();
	}
	
	@When("I am able to add the lowest price to my cart")
	public void i_am_able_to_add_the_lowest_price_to_my_cart() {
		System.out.println("add to cart of that element");
		WishListPage WishListPage = new WishListPage(driver);
		WishListPage.VerifyItemAddedtoCart();
	}
	
	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() throws Exception {
		WishListPage WishListPage = new WishListPage(driver);
		Cartpage Cartpage = new Cartpage(driver);
	
		WishListPage.ClickCartButton();
		Cartpage.ValidateMycartPage();
	}
	

}
