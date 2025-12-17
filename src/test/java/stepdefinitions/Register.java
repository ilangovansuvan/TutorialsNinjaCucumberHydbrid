package stepdefinitions;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;	
	private RegisterPage registerPage;
	@Given("user navigate to Registe page")
	public void user_navigate_to_registe_page() {
		driver= DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickonmyAccount();
		homePage.clickRegister();		
	}

	@When("user enters the details in below fields")
	public void user_enters_the_details_in_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataMap.get("firstName"));
		registerPage.enterLastname(dataMap.get("lastName"));
		registerPage.enterEmail(CommonUtils.getCustomEmail());
		registerPage.enterTelenum(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterconPassword(dataMap.get("password"));
	}
	
	@When("user enters the existing details in below fields")
	public void user_enters_the_existing_details_in_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataMap.get("firstName"));
		registerPage.enterLastname(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelenum(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterconPassword(dataMap.get("password"));
	}

	@When("user selects privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.clickPrivacy();
	}

	@When("user click continue button")
	public void user_click_continue_button() {
		registerPage = new RegisterPage(driver);
		registerPage.clickContinue();
	}

	@Then("user should get account successfully created")
	public void user_should_get_account_successfully_created() {
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);		
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.verifyPageHeading());
	}

	@When("user selects Yes for news letter")
	public void user_selects_yes_for_news_letter() {
		registerPage.clickNewsletter();
	}

	@Then("user should get a proper warning about email")
	public void user_should_get_a_proper_warning_about_email() {		
		Assert.assertTrue(registerPage.verifywarningmsg().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("user dont enters the details")
	public void user_dont_enters_the_details() {
		//intentionally kept blank
		Assert.fail();
	}

	@Then("user should get a proper warning message for every mandatory fields")
	public void user_should_get_a_proper_warning_message_for_every_mandatory_fields() {
		Assert.assertTrue(registerPage.verifywarningmsg().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals(registerPage.getFnamewarning(), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getLnamewarning(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getEmailwarning(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(registerPage.getTelewarning(), "Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(registerPage.getPasswordwarning(), "Password must be between 4 and 20 characters!");		
	}




}
