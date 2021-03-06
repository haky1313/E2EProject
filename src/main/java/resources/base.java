package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public WebDriver driver;
	public Properties prop;
	public static String projectpath=System.getProperty("user.dir");
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		//FileInputStream fis=new FileInputStream("C:\\Users\\haky1\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis=new FileInputStream(projectpath+"\\src\\main\\java\\resources\\data.properties");
		//FileInputStream fis=new FileInputStream(".\\data.properties");
	//	FileInputStream fis=new FileInputStream("./src/main/java/resources/data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		//String browserName=System.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			//execute in chrome driver
			 WebDriverManager.chromedriver().setup();
			 
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\haky1\\eclipse-workspace\\drivers\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\haky1\\eclipse-workspace\\drivers\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\haky1\\eclipse-workspace\\drivers\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		
		return destinationFile;
		
	}
}
