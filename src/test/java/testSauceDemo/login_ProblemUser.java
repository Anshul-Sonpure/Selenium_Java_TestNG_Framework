package testSauceDemo;

import org.testng.annotations.Test;

import pagefiles_SauceDemo.LoginPage;
import testBase.ExtentManager;
import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

public class login_ProblemUser extends testBase
{
    @Test(priority = 1)
    public void login_Problem_User() throws Exception
    { 
        
      
        LoginPage loginpage = new LoginPage();
        ExtentManager.getExtentTest().info("Navigated to Url");
        Thread.sleep(2000);
        
        loginpage.sendUsername(ReadProperties.getData("problemuser"));
        ExtentManager.getExtentTest().info("Problem User Username Entered");
        Thread.sleep(2000);
       
        loginpage.sendPassword(ReadProperties.getData("Password"));
        ExtentManager.getExtentTest().info("Password Entered");
        Thread.sleep(2000);
        
        loginpage.Login();
        ExtentManager.getExtentTest().info("Clicked on Login");
        ExtentManager.getExtentTest().addScreenCaptureFromPath(TakeSnap.capturescreen("Login-Problem-User_"+ExtentManager.timeStamp+".png"));
    }
}


