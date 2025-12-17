package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.WebelementsUtils;

public class RegisterPage {
	WebDriver driver;
	private WebelementsUtils elementsUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new WebelementsUtils(driver); 
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstname;
	
	@FindBy(id = "input-lastname")
	private WebElement lastname;
	
	@FindBy(id = "input-email")
	private WebElement emailname;
	
	@FindBy(id = "input-telephone")
	private WebElement mobnum;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmpassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacypolicybtn;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continuebtn;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsletterbtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	private WebElement getwarningtxt;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement Fnamewarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement Lnamewarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement Telewarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement Pwordwarning;
	
	
	
	public void enterFirstname(String Fname) {
		elementsUtils.typeIntoElement(firstname, CommonUtils.EXPLICIT_WAIT_TIME, Fname);
	}
	
	public void enterLastname(String Lname) {
		elementsUtils.typeIntoElement(lastname, CommonUtils.EXPLICIT_WAIT_TIME, Lname);
	}
	
	public void enterEmail(String Email) {
		elementsUtils.typeIntoElement(emailname, CommonUtils.EXPLICIT_WAIT_TIME, Email);
	}
	
	public void enterTelenum(String tele) {
		elementsUtils.typeIntoElement(mobnum, CommonUtils.EXPLICIT_WAIT_TIME, tele);
	}
	
	public void enterPassword(String pword) {
		elementsUtils.typeIntoElement(password, CommonUtils.EXPLICIT_WAIT_TIME, pword);
	}
	
	public void enterconPassword(String confirmpword) {
		elementsUtils.typeIntoElement(confirmpassword, CommonUtils.EXPLICIT_WAIT_TIME, confirmpword);
	}
	
	public void clickPrivacy() {
		elementsUtils.clickOnElement(privacypolicybtn, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clickContinue() {
		elementsUtils.clickOnElement(continuebtn, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clickNewsletter() {
		elementsUtils.clickOnElement(newsletterbtn, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String verifywarningmsg() {
		return getwarningtxt.getText();
	}
	
	public String getFnamewarning() {
		return Fnamewarning.getText();
	}
	
	public String getLnamewarning() {
		return Lnamewarning.getText();
	}
	
	public String getPasswordwarning() {
		return Pwordwarning.getText();
	}
	
	public String getTelewarning() {
		return Telewarning.getText();
	}
	
	public String getEmailwarning() {
		return emailwarning.getText();
	}
	

}
