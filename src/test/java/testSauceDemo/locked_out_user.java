package testSauceDemo;

import pagefiles_SauceDemo.LoginPage;
import testBase.testBase;
import utililty.ReadProperties;
import org.testng.annotations.Test;
public class locked_out_user extends testBase {

    
    @Test(priority = 1)
    public void login_locked_User() throws Exception
    { 
       
        getDriver().get(ReadProperties.getData("saucedemo"));
       
        LoginPage loginpage = new LoginPage();
        
        Thread.sleep(2000);
       
        loginpage.sendUsername(ReadProperties.getData("lockeduser"));
        Thread.sleep(2000);
       
        loginpage.sendPassword(ReadProperties.getData("Password"));
        
        
        Thread.sleep(2000);
       
       
        loginpage.Login();
    }
}
