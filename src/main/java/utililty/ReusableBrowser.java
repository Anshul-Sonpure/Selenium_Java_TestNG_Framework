package utililty;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableBrowser {
	
		public static WebDriver driver = null;

		
		public static WebDriver getDriver() throws Exception
		{
			String browser =ReadProperties.getData("browser");
			System.out.println("WebBrowser " + browser +" Started:");
			
			try {
			switch (browser) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
				break;
			case "IE":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
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
