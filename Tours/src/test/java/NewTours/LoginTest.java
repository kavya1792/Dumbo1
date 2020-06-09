package NewTours;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.CommonUtils;
import Utils.ConfigClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.LoginPage;

public class LoginTest extends ConfigClass {

	AndroidDriver<AndroidElement> driver=null;
	AppiumDriverLocalService service;
	

	@BeforeMethod
    public void startApp() throws InterruptedException, IOException {
        String configPath = System.getProperty("user.dir") + "\\Testdata\\global.properties";
        FileInputStream fis = new FileInputStream(configPath);
	       driver = capabilities("Url");
		service = startServer();
        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
       
    }

	
    @Test(description="Valid Login details")
    public void loginVerfication() throws Throwable {
    	test=ext.createTest("New tours Login verification") ;    
                  try { 
                 LoginPage login = new LoginPage(driver);
                 login.enterCredentilas();
                  Thread.sleep(3000);
                  String actual=login.clickSignoff(); 
                  String expected="SIGN-OFF";
                  test.log(Status.INFO, "Assertion");
                 Assert.assertEquals(actual, expected);
                  } catch (Throwable e) {
          			test.fail(e);
          			e.printStackTrace();
          			throw e;
                  }       
    }
    
    @Test(description="Invalid login details")
    public void invalidLoginVerification() throws InterruptedException, FileNotFoundException {
    	test = ext.createTest("Invalid Login verification");
 
    	 LoginPage login = new LoginPage(driver);
		login.enterInvalidCredentilas();
         String expected="SIGN-ON";
       String actual=login.textValidation();
         Assert.assertEquals(actual, expected);
    }
         
    
}
