package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By signIn=By.cssSelector("a[href*='sign_in']");
	By title =By.cssSelector(".text-center>h2");
	By navBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		driver=driver2;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	

	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}
}
