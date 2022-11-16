package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class testBase {
	
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	
	
	@BeforeClass
    public void Setup() throws Exception{
		WebDriver webdriver = BrowserSetup.initDriver();
		threadLocalDriver.set(webdriver);
		
	}
	 //get thread-safe driver
    public static WebDriver getDriver(){
        
        return threadLocalDriver.get();
    }

    @AfterClass
    public void tearDown()
    {
    	getDriver().quit();
    	threadLocalDriver.remove();
    }
}
