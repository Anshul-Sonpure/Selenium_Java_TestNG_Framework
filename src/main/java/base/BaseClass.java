package base;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
	
	@BeforeTest
	public void initBrowser() throws Exception
	{
		driver = ReusableBrowser.getDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	}
	
	@AfterTest
	public void DriverQuit()
	{
		driver.quit();
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
		extent.setSystemInfo("AppURl", ReadProperties.getData("saucedemo"));

	}
	@AfterTest
	public void teardown() 
	{
		extent.flush();
		
	}
	@AfterMethod
	public void addscreenshot(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			    Throwable e = result.getThrowable();
			    test.fail(e);
			 test.log(Status.FAIL, e);
			String screenshot = TakeSnap.capturescreen("Test_Failed_"+timeStamp+".png");
			test.addScreenCaptureFromPath(screenshot);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			Throwable e = result.getThrowable();
			test.skip(e);
			 test.log(Status.SKIP, e);
			String screenshot = TakeSnap.capturescreen("Test_SKIP_"+timeStamp+".png");
			test.addScreenCaptureFromPath(screenshot);
		}
	}
}
