package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    public static ExtentReports extent = ExtentManager.createInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult result) {
    	
    	
        ExtentTest extentTest = extent.createTest(result.getTestClass().getName())
                .assignAuthor(System.getProperty("user.name"));
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+ " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
