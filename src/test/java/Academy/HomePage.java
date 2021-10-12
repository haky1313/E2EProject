package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String password) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		log.info(userName+" Log in tried");
		lp.getLogin().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data=new Object [2][2];
		data[0][0]="test1@gmail.com";
		data[0][1]="pass1";
		
		data[1][0]="test2@gmail.com";
		data[1][1]="pass2";
		
		return data;
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
