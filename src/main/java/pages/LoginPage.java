package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.WebelementsUtils;

public class LoginPage {
	
	WebDriver driver;
	private WebelementsUtils elementsUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new WebelementsUtils(driver); 
	}
	
	@FindBy(id = "input-email")
	private WebElement emailtext;
	
	@FindBy(id="input-password")
	private WebElement passwordtxt;
	
	@FindBy(xpath ="//input[@type='submit']")
	private WebElement loginbtn;
	
	@FindBy(xpath ="//div[contains(@class,'alert alert')]")
	private WebElement warningMsg;
	
	public void enterEmail(String email) {
		elementsUtils.typeIntoElement(emailtext, CommonUtils.EXPLICIT_WAIT_TIME, email);
	}
	
	public void enterpassword(String password) {
		elementsUtils.typeIntoElement(passwordtxt, CommonUtils.EXPLICIT_WAIT_TIME, password);
	}
	
	public void clickLogin() {
		elementsUtils.clickOnElement(loginbtn, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String getdisplayofwarningMsg() {
		return warningMsg.getText();
	}
	//never used
	public void clearEmail() {
		emailtext.clear();
	}	
	//never used
	public void clearPassword() {
		passwordtxt.clear();
	}	
	

}
