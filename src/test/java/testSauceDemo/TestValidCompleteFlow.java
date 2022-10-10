package testSauceDemo;
import org.testng.annotations.Test;

import base.BaseClass;
import pagefiles_SauceDemo.CheckoutPage;
import pagefiles_SauceDemo.CompleteCheckout;
import pagefiles_SauceDemo.LoginPage;
import pagefiles_SauceDemo.ProductsPage;
import pagefiles_SauceDemo.UserInfoPage;
import utililty.*;


public class TestValidCompleteFlow extends BaseClass {
	
	
	@Test(priority = 1)
	public void validloginpage() throws Exception
	{ 
		driver.get(ReadProperties.getData("saucedemo"));
		test = extent.createTest("LoginSauceDemo").assignAuthor(System.getProperty("user.name"));
		LoginPage loginpage = new LoginPage();
		test.info("Navigated to Url");
		Thread.sleep(2000);
		test.info("Username Entered");
		loginpage.sendUsername(ReadProperties.getData("UserName"));
		Thread.sleep(2000);
		test.info("Password Entered");
		loginpage.sendPassword(ReadProperties.getData("Password"));
		String screenshot = TakeSnap.capturescreen("Pass_validloginpage_"+timeStamp+".png");
		Thread.sleep(2000);
		test.info("Clicked on Login");
		test.addScreenCaptureFromPath(screenshot);
		loginpage.Login();
	}
	
	@Test(priority = 2)
	public void addProductToCart() throws Exception {
	test = extent.createTest("TestAddtoCart");
	
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

	@Test(priority = 3)
	public void enterUserInfo() throws Exception
	{
		test = extent.createTest("TestEnterUserInfo");
		test.info("Navigated to User Info Page");
		UserInfoPage uip = new UserInfoPage();
		test.info("Entered First Name");
		uip.sendFirstName(ReadProperties.getData("firstname"));
		Thread.sleep(2000);
		test.info("Entered Last Name");
		uip.sendLastName(ReadProperties.getData("lastname"));
		Thread.sleep(2000);
		test.info("Entered Postal Code");
		uip.sendPostCode(ReadProperties.getData("postalcode"));
		Thread.sleep(2000);
		String screenshot = TakeSnap.capturescreen("Pass_enterUserInfo_"+timeStamp+".png");
		test.addScreenCaptureFromPath(screenshot);
		test.info("Clicked Continue");
		uip.clickContinue();
		
	}
	
	@Test(priority = 4)
	public void Checkout() throws Exception
	{
		test = extent.createTest("TestCheckout Page");
		CheckoutPage chk = new CheckoutPage();
		test.info("Navigated to Checkout Page");
		chk.ScrollTotal();
		chk.ValidateTotal();
		test.info("Validated Total");
		Thread.sleep(1000);
		String screenshot = TakeSnap.capturescreen("Pass_Checkout_"+timeStamp+".png");
		test.addScreenCaptureFromPath(screenshot);
		test.info("Clicked on finish");
		chk.clickFinish();
		
	}
	
	@Test(priority = 5)
	public void completeCheckout() throws Exception
	{
		test = extent.createTest("Test CompleteCheckout");
		CompleteCheckout compchk = new CompleteCheckout();
		test.info("Navigated to Checkout-complete");
		compchk.ValidateCheckout();
		test.info("Validated Checkout Message");
		String screenshot = TakeSnap.capturescreen("Pass_completeCheckout_"+timeStamp+".png");
		test.addScreenCaptureFromPath(screenshot);
		Thread.sleep(1000);
		compchk.Logout();
		test.info("Logout Successful");
	}
}