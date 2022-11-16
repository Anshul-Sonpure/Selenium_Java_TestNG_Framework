package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utililty.ReadProperties;
import utililty.ReusableBrowser;
import utililty.TakeSnap;

public class BaseClass extends ReusableBrowser {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH_mm_ss").format(new Date());
	public String screenshot;
	protected static 
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	
	
	@BeforeTest
	public void initBrowser() throws Exception
	{
		driver = ReusableBrowser.getDriver();
		threadLocalDriver.set(driver);
	}
	 //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }
	
	@AfterTest
	public void DriverQuit()
	{
	    getDriver().quit();
	    threadLocalDriver.remove();
	}
	
	@BeforeTest
	public void Initialise_ExtentReport() throws Exception 
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/Reports/extentreport_" + timeStamp + ".html");
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("JVM", System.getProperty("java.runtime.version"));
		extent.setSystemInfo("UserDirectory", System.getProperty("user.dir"));
		extent.setSystemInfo("User", System.getProperty("user.name"));
		extent.setSystemInfo("Browser", ReadProperties.getData("browser"));
		extent.setSystemInfo("AppUrl", ReadProperties.getData("saucedemo"));

	}
	@AfterTest
	public void teardown() 
	{
		extent.flush();
		
	}
	@AfterMethod
	public void addscreenshot(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			    Throwable e = result.getThrowable();
			    test.fail(e);
			 test.log(Status.FAIL, e);
			 screenshot = TakeSnap.capturescreen("Test_Failed_"+timeStamp+".png");
			test.addScreenCaptureFromPath(screenshot);
			
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			Throwable e = result.getThrowable();
			test.skip(e);
			 test.log(Status.SKIP, e);
			 screenshot = TakeSnap.capturescreen("Test_SKIP_"+timeStamp+".png");
			test.addScreenCaptureFromPath(screenshot);
			
		}
	}
}
