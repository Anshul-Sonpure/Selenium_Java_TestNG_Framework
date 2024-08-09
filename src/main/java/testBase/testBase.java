package testBase;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import utililty.ReadProperties;

public class testBase extends ListenerTest {

    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeClass
    public void Setup() throws Exception {

        WebDriver webdriver = BrowserManager.initDriver();
        threadLocalDriver.set(webdriver);
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        getDriver().get(ReadProperties.getData("saucedemo"));
        
    }

    // get thread-safe driver
    public static WebDriver getDriver() {

        return threadLocalDriver.get();
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
        threadLocalDriver.remove();
        ExtentManager.removeExtentTest();
    }

  
}
