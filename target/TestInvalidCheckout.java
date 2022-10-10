package testSauceDemo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import pagefiles.LoginPage;
import utililty.PropertiesUtils;
import utililty.TakeSnap;

public class TestInvalidCheckout extends BaseClass  {
	
	public static ExtentTest test2;
//	@Test(priority = 1)
//	public void validloginpage() throws Exception
//	{ 
//		test2 = extent.createTest("LoginSauceDemo");
//	
//		LoginPage loginpage = new LoginPage();
//		test.info("Navigated to Url");
//		Thread.sleep(2000);
//		test.info("Username Entered");
//		loginpage.sendUsername(PropertiesUtils.ReadPropertyfile("UserName"));
//		Thread.sleep(2000);
//		test.info("Password Entered");
//		loginpage.sendPassword(PropertiesUtils.ReadPropertyfile("Password"));
//		String screenshot = TakeSnap.capturescreen("Pass_validloginpage_"+timeStamp+".png");
//		Thread.sleep(2000);
//		test.info("Clicked on Login");
//		test.addScreenCaptureFromPath(screenshot);
//		loginpage.Login();
//	}

}
