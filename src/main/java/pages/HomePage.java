package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.WebelementsUtils;

public class HomePage {
	
	WebDriver driver;
	private WebelementsUtils elementsUtils;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new WebelementsUtils(driver); 
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myaccountdropmenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginbtn;
	
	@FindBy(linkText = "Register")
	private WebElement Registerbtn;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement Searchtxt;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-defa')]")
	private WebElement Searchbtn;
	
	public void clickonmyAccount() {
		elementsUtils.clickOnElement(myaccountdropmenu, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clicklogin() {
		elementsUtils.clickOnElement(loginbtn, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clickRegister() {
		elementsUtils.clickOnElement(Registerbtn, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void EnterSearchitem(String Searchtext) {
		elementsUtils.typeIntoElement(Searchtxt, CommonUtils.EXPLICIT_WAIT_TIME, Searchtext);
	}
	//additionally i have added
	public void EnterInvalidSearchitem(String invalidSearchtext) {
		elementsUtils.typeIntoElement(Searchtxt, CommonUtils.EXPLICIT_WAIT_TIME, invalidSearchtext);
	}
	
	public void ClickSearchBtn() {
		elementsUtils.clickOnElement(Searchbtn, CommonUtils.EXPLICIT_WAIT_TIME);
	}

}
