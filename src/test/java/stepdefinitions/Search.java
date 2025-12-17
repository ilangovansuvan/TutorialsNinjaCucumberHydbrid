package stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;


public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	@Given("user opens the application")
	public void user_opens_the_application() {
		driver= DriverFactory.getDriver();		
	}

	@When("user enters valid product {string}")
	public void user_enters_valid_product(String validproduct) {
		homePage = new HomePage(driver);
		homePage.EnterSearchitem(validproduct);
	}

	@When("user clicks search button")
	public void user_clicks_search_button() {
		homePage.ClickSearchBtn();
	}

	@Then("user should get the valid product details")
	public void user_should_get_the_valid_product_details() {
		searchResultPage = new SearchResultPage(driver);
		Assert.assertTrue(searchResultPage.checkStatusofValidproduct());
	}
	
	@When("user enters invalid product {string}")
	public void user_enters_invalid_product(String invali_product) {
		homePage = new HomePage(driver);
		homePage.EnterInvalidSearchitem(invali_product);
	}


	@Then("user should get the message about no product matching")
	public void user_should_get_the_message_about_no_product_matching() {
		searchResultPage = new SearchResultPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.",searchResultPage.getNoproductwarning() );
	}

	@When("user enters dont enter product name")
	public void user_enters_dont_enter_product_name() {
		homePage = new HomePage(driver);
	}




}
