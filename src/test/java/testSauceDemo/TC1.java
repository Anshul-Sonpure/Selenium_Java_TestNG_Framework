package testSauceDemo;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

public class TC1 extends testBase {
	
	@Test
	public void Test1(ITestResult result) throws Exception
	{
		Thread.sleep(2000);
//		getDriver().get("https://www.gmail.com");
		getDriver().get(ReadProperties.getData("saucedemo"));
		Thread.sleep(2000);
		String sc1 = TakeSnap.capturescreen("Test_Skipped_"+timeStamp+".png");
		test.get().addScreenCaptureFromBase64String(sc1, "screenshot");
	}

}
