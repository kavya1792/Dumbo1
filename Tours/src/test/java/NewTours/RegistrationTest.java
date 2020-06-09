package NewTours;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ConfigClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.RegistrationPage;

public class RegistrationTest extends ConfigClass {

	AndroidDriver<AndroidElement> driver = null;
	AppiumDriverLocalService service; 

	
	@BeforeMethod
    public void startApp() throws InterruptedException, IOException {
        String configPath = System.getProperty("user.dir") + "\\Testdata\\global.properties";
        FileInputStream fis = new FileInputStream(configPath);
	       driver = capabilities("Url");
		service = startServer();
        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        test=ext.createTest("Registration");
       
    }
	

    @Test(description="Enter values for Registration") 
    public void VerifyConfirmationPage() throws InterruptedException {
    
    	test = ext.createTest("VerifyRegistrationHeadings");
			RegistrationPage rp = new RegistrationPage(driver);
			rp.clickRegister();
			rp.RegistrationValues();
			String actual=rp.validateText();
			String expected="Dear Meena Nandish,";
			Assert.assertEquals(actual, expected);
			
		 
    }


}
