package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		driver= DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickonmyAccount();
		homePage.clicklogin();
	}

	@When("User has enter valid email address {string}")
	public void user_has_enter_valid_email_address(String validemail) {
		loginpage = new LoginPage(driver);
		driver.findElement(By.id("input-email")).clear();
		loginpage.enterEmail(validemail);
	}

	@When("user has enter valid password {string}")
	public void user_has_enter_valid_password(String validpassword) {
		driver.findElement(By.id("input-password")).clear();
		loginpage.enterpassword(validpassword);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.clickLogin();
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		AccountPage actpage = new AccountPage(driver);		
		Assert.assertTrue(actpage.displayStatusofEdityouraccountinfo());
	}
//newly correction on invalid email
	@When("User has enter invalid email address {string}")
	public void user_has_enter_invalid_email_address(String invalidemail) {
		//loginpage.clearEmail();
		driver.findElement(By.id("input-email")).clear();
		loginpage = new LoginPage(driver);	
		loginpage.enterEmail(CommonUtils.getCustomEmail());
	}

	@When("user has enter invalid password {string}")
	public void user_has_enter_invalid_password(String invalidpassword) {
		//loginpage.clearPassword();
		driver.findElement(By.id("input-password")).clear();
		loginpage.enterpassword(invalidpassword);
	}

	@Then("user should get proper warning message")
	public void user_should_get_proper_warning_message() {
		Assert.assertTrue(loginpage.getdisplayofwarningMsg().contains("No match for E-Mail Address and/or Password."));
	}

	@When("User donot enter email address")
	public void user_donot_enter_email_address() {
		loginpage = new LoginPage(driver);	
		//loginpage.clearEmail();
		driver.findElement(By.id("input-email")).clear();	
	}

	@When("user donot enter password")
	public void user_donot_enter_password() {
		//loginpage.clearPassword();
		driver.findElement(By.id("input-password")).clear();
	}

}
