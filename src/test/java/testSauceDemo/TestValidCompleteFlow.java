package testSauceDemo;
import org.testng.annotations.Test;

import pagefiles_SauceDemo.CheckoutPage;
import pagefiles_SauceDemo.CompleteCheckout;
import pagefiles_SauceDemo.LoginPage;
import pagefiles_SauceDemo.ProductsPage;
import pagefiles_SauceDemo.UserInfoPage;
import testBase.testBase;
import utililty.*;


public class TestValidCompleteFlow extends testBase{
	
	
	@Test(priority = 1)
	public void validloginpage() throws Exception
	{ 
	    testBase.getDriver().get(ReadProperties.getData("saucedemo"));
		LoginPage loginpage = new LoginPage();
		
		Thread.sleep(2000);
	
		loginpage.sendUsername(ReadProperties.getData("UserName"));
		Thread.sleep(2000);
		
		loginpage.sendPassword(ReadProperties.getData("Password"));
		
		Thread.sleep(2000);
	
		loginpage.Login();
	}
	
	@Test(priority = 2)
	public void addProductToCart() throws Exception {
	ProductsPage Prdpage = new ProductsPage();

	Thread.sleep(2000);
	Prdpage.clickBackpack();

	Thread.sleep(2000);
	
	Prdpage.clickAdd_to_Cart();
	Thread.sleep(2000);
	
	Prdpage.clickShopping_cart_link();
	Thread.sleep(2000);
	
	Prdpage.clickCheckout();

}

	@Test(priority = 3)
	public void enterUserInfo() throws Exception
	{
	   
		UserInfoPage uip = new UserInfoPage();
		
		uip.sendFirstName(ReadProperties.getData("firstname"));
		Thread.sleep(2000);
		
		uip.sendLastName(ReadProperties.getData("lastname"));
		Thread.sleep(2000);
		
		uip.sendPostCode(ReadProperties.getData("postalcode"));
		Thread.sleep(2000);
		
		uip.clickContinue();
		
	}
	
	@Test(priority = 4)
	public void Checkout() throws Exception
	{
		
		CheckoutPage chk = new CheckoutPage();
		
		chk.ScrollTotal();
		chk.ValidateTotal();
		
		Thread.sleep(1000);
		
		
		chk.clickFinish();
		
	}
	
	@Test(priority = 5)
	public void completeCheckout() throws Exception
	{
		
		CompleteCheckout compchk = new CompleteCheckout();
		
		compchk.ValidateCheckout();
		
		
		Thread.sleep(1000);
		compchk.Logout();
	
	}
}