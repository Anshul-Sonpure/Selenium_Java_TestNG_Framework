package base;

import java.text.SimpleDateFormat;

import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utililty.TakeSnap;
import utililty.PropertiesUtils;
import java.util.Date;

public class ConfigureExtent extends BaseClass{
	
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;

	public static ExtentTest test;
	public static String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH_mm_ss").format(new Date());
	
	@BeforeTest
	public void Extent_Initialise() throws Exception {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/Reports/extentreport_" + timeStamp + ".html");
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("JVM", System.getProperty("java.runtime.version"));
		extent.setSystemInfo("UserDirectory", System.getProperty("user.dir"));
		extent.setSystemInfo("Browser", PropertiesUtils.ReadPropertyfile("browser"));
		extent.setSystemInfo("AppURl", PropertiesUtils.ReadPropertyfile("STG_Env_Url"));

	}
	@AfterTest
	public void teardown() {
		extent.flush();
		
	}
	@AfterMethod
	public void addscreenshot(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String screenshot = TakeSnap.capturescreen("Test_Pass_"+timeStamp+".png");
			test.addScreenCaptureFromPath(screenshot);
		}
		else if(result.getStatus()==ITestResult.FAILURE)
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
			test.fail(e);
			 test.log(Status.SKIP, e);
			String screenshot = TakeSnap.capturescreen("Test_SKIP_"+timeStamp+".png");
			test.addScreenCaptureFromPath(screenshot);
		}
	}
}
