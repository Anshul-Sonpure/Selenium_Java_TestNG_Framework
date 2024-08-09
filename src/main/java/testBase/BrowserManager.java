package testBase;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utililty.ReadProperties;

public class BrowserManager {
	public static  WebDriver driver = null;
	
	
	public static WebDriver initDriver() throws Exception
	{
		ResourceBundle resourcebundle = ResourceBundle.getBundle("newconfig");
		String browser = resourcebundle.getString("browser");
		System.out.println("Browser initialized as :"+browser);
		
		if(browser.equalsIgnoreCase("Chrome") )
		{
		    WebDriverManager.chromedriver().clearDriverCache().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		else
		{
			System.out.println(browser+" Didn't matched any browser specified in properties file");
		}
		return driver;
	}

}
