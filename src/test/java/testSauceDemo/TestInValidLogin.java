package testSauceDemo;

import org.testng.annotations.Test;

import base.BaseClass;
import pagefiles_SauceDemo.LoginPage;
import pagefiles_SauceDemo.ProductsPage;
import utililty.ReadProperties;
import utililty.TakeSnap;

public class TestInValidLogin extends BaseClass 
{
	@Test(priority = 1)
	public void validloginpage() throws Exception
	{ 
		driver.get(ReadProperties.getData("saucedemo"));
		test = extent.createTest("Test locked_out_user").assignAuthor(System.getProperty("user.name"));
	
		LoginPage loginpage = new LoginPage();
		test.info("Navigated to Url");
		Thread.sleep(2000);
		test.info("Username Entered");
		loginpage.sendUsername(ReadProperties.getData("invalid_Username"));
		Thread.sleep(2000);
		test.info("Password Entered");
		loginpage.sendPassword(ReadProperties.getData("Password"));
		loginpage.Login();
		String screenshot = TakeSnap.capturescreen("Pass_validloginpage_"+timeStamp+".png");
		Thread.sleep(2000);
		test.info("Clicked on Login");
		test.addScreenCaptureFromPath(screenshot);
		
	}
	
	@Test(priority = 2)
	public void addProductToCart() throws Exception {
	
	ProductsPage Prdpage = new ProductsPage();
	test.info("Navigated to Product Page");
	Thread.sleep(2000);
	Prdpage.clickBackpack();
	test.info("Clicked on BackPack");
	Thread.sleep(2000);
	test.info("Clicked on Add to Cart");
	Prdpage.clickAdd_to_Cart();
	Thread.sleep(2000);
	test.info("Clicked on Cart");
	Prdpage.clickShopping_cart_link();
	Thread.sleep(2000);
	String screenshot = TakeSnap.capturescreen("Pass_addProductToCart_"+timeStamp+".png");
	test.addScreenCaptureFromPath(screenshot);
	Prdpage.clickCheckout();

}
}


