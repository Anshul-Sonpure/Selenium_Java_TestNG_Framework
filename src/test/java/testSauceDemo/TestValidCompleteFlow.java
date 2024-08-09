package testSauceDemo;
import org.testng.annotations.Test;

import pagefiles_SauceDemo.CheckoutPage;
import pagefiles_SauceDemo.CompleteCheckout;
import pagefiles_SauceDemo.LoginPage;
import pagefiles_SauceDemo.ProductsPage;
import pagefiles_SauceDemo.UserInfoPage;
import testBase.ExtentManager;
import testBase.testBase;
import utililty.*;


public class TestValidCompleteFlow extends testBase{
	
	
	@Test(priority = 1)
	public void validloginpage() throws Exception
	{ 
	    
		LoginPage loginpage = new LoginPage();
		ExtentManager.getExtentTest().info("Navigated to Url");
		Thread.sleep(2000);
		
		loginpage.sendUsername(ReadProperties.getData("UserName"));
		Thread.sleep(2000);
		ExtentManager.getExtentTest().info("Standard User Username Entered");
		loginpage.sendPassword(ReadProperties.getData("Password"));
		
		Thread.sleep(2000);
		ExtentManager.getExtentTest().info("Password Entered");
		loginpage.Login();
		ExtentManager.getExtentTest().info("Clicked Login");
	}
	
	@Test(priority = 2)
	public void addProductToCart() throws Exception {
	ProductsPage Prdpage = new ProductsPage();
	ExtentManager.getExtentTest().info("Navigated to Product Page");
	Thread.sleep(2000);
	Prdpage.clickBackpack();
	
	Thread.sleep(2000);
	ExtentManager.getExtentTest().info("Selected BackPack");
	Prdpage.clickAdd_to_Cart();
	
	Thread.sleep(2000);
	ExtentManager.getExtentTest().info("BackPack Added to Cart");
	ExtentManager.getExtentTest().addScreenCaptureFromPath(TakeSnap.capturescreen("BackPack Added to Cart_"+ExtentManager.timeStamp+".png"));
	Prdpage.clickShopping_cart_link();
	ExtentManager.getExtentTest().info("Clicked on Cart");
	Thread.sleep(2000);
	Prdpage.clickCheckout();
	ExtentManager.getExtentTest().info("Clicked Checkout");

}

	@Test(priority = 3)
	public void enterUserInfo() throws Exception
	{
	   
		UserInfoPage uip = new UserInfoPage();
		ExtentManager.getExtentTest().info("Navigated to User Info Page");
		
		uip.sendFirstName(ReadProperties.getData("firstname"));
		Thread.sleep(2000);
		ExtentManager.getExtentTest().info("Entered First Name");
		uip.sendLastName(ReadProperties.getData("lastname"));
		Thread.sleep(2000);
		ExtentManager.getExtentTest().info("Entered Last Name");
		uip.sendPostCode(ReadProperties.getData("postalcode"));
		Thread.sleep(2000);
		ExtentManager.getExtentTest().info("Entered Postal Code");
		ExtentManager.getExtentTest().addScreenCaptureFromPath(TakeSnap.capturescreen("UserDetails_"+ExtentManager.timeStamp+".png"));
		uip.clickContinue();
		ExtentManager.getExtentTest().info("Clicked Continue");
		
	}
	
	@Test(priority = 4)
	public void Checkout() throws Exception
	{
	    
		CheckoutPage chk = new CheckoutPage();
	    ExtentManager.getExtentTest().info("Navigated to Checkout Page");
		chk.ScrollTotal();
		
		chk.ValidateTotal();
		ExtentManager.getExtentTest().info("Validated Total");
		Thread.sleep(1000);
		ExtentManager.getExtentTest().addScreenCaptureFromPath(TakeSnap.capturescreen("Validated Total_"+ExtentManager.timeStamp+".png"));
		chk.clickFinish();
		ExtentManager.getExtentTest().info("Clicked on Finish");
		
	}
	
	@Test(priority = 5)
	public void completeCheckout() throws Exception
	{
		
		CompleteCheckout compchk = new CompleteCheckout();
		ExtentManager.getExtentTest().info("Navigated to Checkout Complete");
		compchk.ValidateCheckout();
		ExtentManager.getExtentTest().info("Validated Checkout Message");
		ExtentManager.getExtentTest().addScreenCaptureFromPath(TakeSnap.capturescreen("Validated Checkout_"+ExtentManager.timeStamp+".png"));
		Thread.sleep(1000);
		compchk.Logout();
		ExtentManager.getExtentTest().info("Logout Successfully");
	
	}
}