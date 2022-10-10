package utililty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableBrowser {
	
		public static WebDriver driver;

		
		public static WebDriver getDriver() throws Exception
		{
			String browser =ReadProperties.getData("browser");
			System.out.println("WebBrowser " + browser +" Started:");
			
			try {
			switch (browser) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "IE":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println(browser+" Didn't matched any browser specified in properties file");
			}
			
		
			}
			catch(Exception e)
			{
			  e.printStackTrace();
			
			}
			return driver;
		}
	
	
	}
