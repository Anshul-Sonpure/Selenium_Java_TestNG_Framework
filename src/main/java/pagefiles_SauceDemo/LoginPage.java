package pagefiles_SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;


public class LoginPage extends BaseClass{
	
	
	public LoginPage() throws Exception
	{
		
		PageFactory.initElements(driver,this);
	}
	
	//username text box
	@FindBy(xpath="//input[@name='user-name'] ")
	private WebElement username;
	
	
	//password testbox
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='login-button']")
	private WebElement Login;
 	

	public LoginPage sendUsername(String uname) throws Exception {
		username.sendKeys(uname);
		return this;
	}

	

	public LoginPage sendPassword(String pswd) throws Exception {
		password.sendKeys(pswd);
		return this;
	}
	
	public ProductsPage Login() throws Exception 
	{
		Login.click();
		return new ProductsPage();
	}
	

}
