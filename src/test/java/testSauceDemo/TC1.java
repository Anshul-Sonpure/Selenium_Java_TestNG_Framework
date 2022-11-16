package testSauceDemo;

import org.testng.annotations.Test;

import testBase.testBase;
import utililty.ReadProperties;

public class TC1 extends testBase {
	
	@Test
	public void Test1() throws Exception
	{
		Thread.sleep(2000);
//		getDriver().get("https://www.gmail.com");
		getDriver().get(ReadProperties.getData("saucedemo"));
		Thread.sleep(2000);
	}

}
