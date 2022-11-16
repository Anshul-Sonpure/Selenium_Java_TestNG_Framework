package testSauceDemo;

import org.testng.annotations.Test;

import pagefiles_SauceDemo.LoginPage;
import testBase.testBase;
import utililty.ReadProperties;

public class performance_glitch_user extends testBase {
    
    
    @Test(priority = 1)
    public void login_glitch_User() throws Exception
    { 
        testBase.getDriver().get(ReadProperties.getData("saucedemo"));
       
        LoginPage loginpage = new LoginPage();
       
        Thread.sleep(2000);
       
        loginpage.sendUsername(ReadProperties.getData("glitchuser"));
        Thread.sleep(2000);
       
        loginpage.sendPassword(ReadProperties.getData("Password"));
        
        Thread.sleep(2000);
     
        loginpage.Login();
    }

}
