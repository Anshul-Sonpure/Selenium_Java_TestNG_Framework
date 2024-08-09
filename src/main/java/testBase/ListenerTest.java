package testBase;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utililty.TakeSnap;

public class ListenerTest implements ITestListener  {
    
    public static String screenshot;
    public static Logger logger = LogManager.getLogger("applog");
    String classname;
    @Override
    public void onTestStart(ITestResult result) {
       
        classname = result.getTestClass().getName();
        classname=classname.replace("testSauceDemo.","");
        
        ExtentTest test = ExtentManager.getExtentReports().createTest(classname)
                .createNode(result.getMethod().getMethodName())
                .assignAuthor(System.getProperty("user.name"));
        ExtentManager.setExtentTest(test);
        logger.log(Level.INFO, "Starting "+ classname); 
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getExtentTest().log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+ "Test Passed");
        
        logger.log(Level.INFO, "Test Successed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getExtentTest().fail(result.getThrowable());
        ExtentManager.getExtentTest().log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+ "Test Failed");
        
        try {
            screenshot = TakeSnap.capturescreen("Test_Failed_"+ExtentManager.timeStamp+".png");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("An Error occurred",e);
        }
        ExtentManager.getExtentTest().addScreenCaptureFromPath(screenshot);
        
        logger.log(Level.INFO, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getExtentTest().skip(result.getThrowable());
        ExtentManager.getExtentTest().log(Status.SKIP,"Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
        try {
            screenshot = TakeSnap.capturescreen("Test_Skipped_"+ExtentManager.timeStamp+".png");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("An Error occurred",e);
        }
        ExtentManager.getExtentTest().addScreenCaptureFromPath(screenshot);
        
        logger.log(Level.INFO, "Test Skipped");
        
    }


    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtentReports().flush();
        // Clean up ThreadLocal instances
        ExtentManager.removeExtentTest();
        logger.log(Level.INFO, "Test Finished");
    }
    
    

}
