package pagefiles_ParaBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class RegisterUserPage extends BaseClass {
	
	public RegisterUserPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//a[.='Register']")
	private WebElement register;
	
	@FindBy(xpath = "//input[@id='customer.firstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@id='customer.lastName']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@id='customer.address.street']")
	private WebElement street;
	@FindBy(xpath = "//input[@id='customer.address.city']")
	private WebElement city;
	@FindBy(xpath = "//input[@id='customer.address.state']")
	private WebElement state;
	@FindBy(xpath = "//input[@id='customer.address.zipCode']")
	private WebElement zipCode;
	@FindBy(xpath = "//input[@id='customer.phoneNumber']")
	private WebElement phoneNumber;
	@FindBy(xpath = "//input[@id='customer.ssn']")
	private WebElement ssn;
	@FindBy(xpath = "//input[@id='customer.username']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='customer.password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='repeatedPassword']")
	private WebElement repeatedPassword;
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement Register;
	
	
	public void clickRegister()
	{
		register.click();
	}
	public void SetUserData(String args [])
	{
		firstName.sendKeys(args[0]);
		lastName.sendKeys(args[1]);
		street.sendKeys(args[2]);
		city.sendKeys(args[3]);
		state.sendKeys(args[4]);
		zipCode.sendKeys(args[5]);
		phoneNumber.sendKeys(args[6]);
		ssn.sendKeys(args[7]);
		username.sendKeys(args[8]);
		password.sendKeys(args[9]);
		repeatedPassword.sendKeys(args[10]);
		Register.click();
		
	}

	

}
