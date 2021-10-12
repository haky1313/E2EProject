package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import resources.base;

public class ValidateTitle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialsed");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	@Test
	public void validateTitle() throws IOException
	{
		
		LandingPage l = new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		log.info("sucessfully validated text message");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
