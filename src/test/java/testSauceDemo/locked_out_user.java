package testSauceDemo;

import pagefiles_SauceDemo.LoginPage;
import testBase.ExtentManager;
import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

import org.testng.annotations.Test;
public class locked_out_user extends testBase {

    
    @Test(priority = 1)
    public void login_locked_User() throws Exception
    { 
        
        LoginPage loginpage = new LoginPage();
        ExtentManager.getExtentTest().info("Navigated to Url");
        Thread.sleep(2000);
        loginpage.sendUsername(ReadProperties.getData("lockeduser"));
        ExtentManager.getExtentTest().info("Locked Out Username Entered");
        Thread.sleep(2000);
        loginpage.sendPassword(ReadProperties.getData("Password"));
        ExtentManager.getExtentTest().info("Password Entered");
        Thread.sleep(2000);
        loginpage.Login();
        ExtentManager.getExtentTest().info("Clicked on Login");
        ExtentManager.getExtentTest().addScreenCaptureFromPath(TakeSnap.capturescreen("Login-Locked-User_"+ExtentManager.timeStamp+".png"));
        
        
      
    }
}
