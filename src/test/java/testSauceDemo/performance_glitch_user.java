package testSauceDemo;

import org.testng.annotations.Test;

import pagefiles_SauceDemo.LoginPage;
import testBase.ExtentManager;
import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

public class performance_glitch_user extends testBase {
    
    
    @Test(priority = 1)
    public void login_glitch_User() throws Exception
    { 
        
       
        LoginPage loginpage = new LoginPage();
        ExtentManager.getExtentTest().info("Navigated to Url");
        Thread.sleep(2000);
       
        loginpage.sendUsername(ReadProperties.getData("glitchuser"));
        Thread.sleep(2000);
        ExtentManager.getExtentTest().info("Glitch User Username Entered");
        loginpage.sendPassword(ReadProperties.getData("Password"));
        
        Thread.sleep(2000);
        ExtentManager.getExtentTest().info("Password Entered");
        loginpage.Login();
        ExtentManager.getExtentTest().info("Clicked on Login");
        ExtentManager.getExtentTest().addScreenCaptureFromPath(TakeSnap.capturescreen("Login-performance_glitch-User_"+ExtentManager.timeStamp+".png"));
        
    }

}
