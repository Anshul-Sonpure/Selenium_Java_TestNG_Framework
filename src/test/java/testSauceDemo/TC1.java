package testSauceDemo;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

public class TC1 extends testBase {
	
	@Test
	public void Test1(ITestResult result) throws Exception
	{
		getDriver().get("https://www.saucedemo.com");
		String name = getDriver().findElement(By.xpath("//div[@id='login_credentials']")).getText();
		System.out.println("====>"+name);
	}

}
