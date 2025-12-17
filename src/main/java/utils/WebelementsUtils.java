package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebelementsUtils {
	WebDriver driver;
	
	public WebelementsUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement waitforElement(WebElement element, long durationinSec) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSec));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	public void clickOnElement(WebElement element, long durationinSec) {
		WebElement webelement = waitforElement(element, durationinSec);
		webelement.click();
	}
	
	public void typeIntoElement(WebElement element, long durationinSec, String text) {		
		WebElement webelement = waitforElement(element, durationinSec);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(text);
	}
	
	public void selectOptioninDropdown(WebElement element, String dropdown, long durationinSec) {
		WebElement webelement = waitforElement(element, durationinSec);
		Select select = new Select(webelement);
		select.selectByVisibleText(dropdown);
	}
	
	public void acceptAlert(long durationinSec) {
		Alert alert = waitforAlert(durationinSec);
		alert.accept();
	}
	
	public void dismissAlert(long durationinSec) {
		Alert alert = waitforAlert(durationinSec);
		alert.dismiss();;
	}
	
	public Alert waitforAlert(long durationinSec) {
		Alert alert=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSec));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return alert;
	}
	
	public void mouseHoverandClick(WebElement element,long durationinSec ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSec));
		WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(webelement).click().build().perform();		
	}
	
	public void javaScriptClick(WebElement element, long durationinSec) {
		WebElement webelement = waitforElement(element, durationinSec);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webelement);
	}
	
	public void javascriptType(WebElement element, long durationinSec, String texttoTyped) {
		WebElement webelement = waitforElement(element, durationinSec);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+texttoTyped+"'", webelement);
	}

}
