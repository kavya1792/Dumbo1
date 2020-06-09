package NewTours;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.CommonUtils;
import Utils.ConfigClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.LoginPage;
import pageObjects.ReservationPage;

public class ReservationTest extends ConfigClass {
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
        
       
       
    }
	@Test(description="Login to New tours and validate headers")
	public void resrvationVerification() throws FileNotFoundException {
		 test = ext.createTest("Login verification");
		 LoginPage login=new LoginPage(driver);
		 ReservationPage reserve = new ReservationPage(driver);
		 CommonUtils cu=new CommonUtils(driver);
		 	login.enterCredentilas();
			String actualhead1 = reserve.get_actualHeading(); 
			System.out.println(actualhead1);
			String expecthead1 = cu.getPropertyValue("reservation", "header1");
			AssertJUnit.assertEquals(actualhead1, expecthead1);
			String actualhead2 = reserve.get_actualHeading2();
			String expecthead2 = cu.getPropertyValue("reservation", "header2");
			Assert.assertEquals(actualhead2, expecthead2);
	}
	
	@Test(description="Enter details in Flightbooking page")
	public void flightBooking() throws Throwable {
		 LoginPage login=new LoginPage(driver);
		 ReservationPage reserve = new ReservationPage(driver);
		 CommonUtils cu=new CommonUtils(driver);
		test = ext.createTest("flightBooking");
		try {
			login.enterCredentilas();
			test.log(Status.INFO,"Reservation page opened");
			reserve.validatefindFlighter();
			Thread.sleep(3000);
			reserve.click_radio();
			reserve.click_submit();
			Assert.assertTrue(reserve.validateselectFlight());
			reserve.click_radiodepart();
			reserve.click_radioreturn();
			reserve.click_clickflight();
			reserve.firstName();
			reserve.lastName();
			reserve.dropdownMeal();
			test.log(Status.INFO,"Meal selected from dropdown");
			reserve.dropdownCredit();
			test.log(Status.INFO,"Type of credit card selected");
			reserve.creditNum();
			reserve.dropdownCreditMonth();
			test.log(Status.INFO,"Credit card expiry month selected");
			reserve.dropdownCreditYear();
			test.log(Status.INFO,"Credit card expiry year selected");
			reserve.creditFname();
			reserve.creditMname();
			reserve.creditLname();
			reserve.ticketLess();
			reserve.checkbillAddress();
			reserve.validatebillAddr();
			reserve.validatebillCity();
			reserve.validatebillState();
			reserve.validatebillZip();
			test.log(Status.INFO,"Validated billing postal code");
			test.log(Status.INFO,"Clicked on confrimation button");
			Assert.assertTrue(reserve.flightBookingConformationMsg());
			reserve.clickLogOut();
		} catch (Throwable e) {
			test.fail(e);
			e.printStackTrace();
			throw e;
		}
	}

}
