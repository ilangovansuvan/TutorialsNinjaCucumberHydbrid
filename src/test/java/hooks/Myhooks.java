package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfiqReader;

public class Myhooks {
	WebDriver driver;
	@Before
	public void setup() {
		Properties prop = ConfiqReader.initProperties();
		driver=DriverFactory.initBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		String scenarioname = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", scenarioname);
		}
		driver.quit();
	}

}
