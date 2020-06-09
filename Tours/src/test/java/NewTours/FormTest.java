package NewTours;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.CommonUtils;
import Utils.ConfigClass;
import Utils.Screenshot;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.CheckOutPage;
import pageObjects.FormPage;
import pageObjects.HomePage;

public class FormTest extends ConfigClass {

	AndroidDriver<AndroidElement> driver;
	AppiumDriverLocalService service;


	@BeforeClass
    public void start() throws InterruptedException, IOException {
        String configPath = System.getProperty("user.dir") + "\\Testdata\\global.properties";
        FileInputStream fis = new FileInputStream(configPath);
              driver = capabilities("GeneralStoreApp");
    
        service = startServer();
        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	


	@Test(description="Home page login details")
	public void formVerification() throws IOException, InterruptedException {

		test = ext.createTest("HomePage");

		FormPage FormPage = new FormPage(driver);
		FormPage.nameField.sendKeys("Meena");
		test.log(Status.INFO, "User name entered");
		driver.hideKeyboard();
		FormPage.femaleOption.click();
		test.log(Status.INFO, "Female option selected");
		FormPage.radioClick.click();
		CommonUtils u = new CommonUtils(driver);
		u.scrollToText("Austria");
		test.log(Status.INFO, "Scrolled to select the country");
		FormPage.shopButton.click();

	} 

	@Test(description="Products adding to cart")
	public void productVerification() throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);

		homePage.productNames("Air Jordan 4 Retro");
		test.log(Status.INFO, "First product selected");
		homePage.productNames("Air Jordan 1 Mid SE");
		test.log(Status.INFO, "Second product selected");
		homePage.cartButton.click();
		test.log(Status.INFO, "Successfully added to cart");
		Thread.sleep(6000);
	}

	@Test(dependsOnMethods = { "productVerification" })
	public void productSumVerification() throws IOException, InterruptedException {

		CheckOutPage checkout = new CheckOutPage(driver); 

		String amount1 = checkout.productlist1.get(0).getText();
		amount1 = amount1.substring(1);
		double amount1value = Double.parseDouble(amount1);
		test.log(Status.INFO, "First product total converted to decimal value");
		String amount2 = checkout.productlist2.get(1).getText();
		amount2 = amount2.substring(1);
		double amount2value = Double.parseDouble(amount2);
		test.log(Status.INFO, "Second product total converted to decimal value");
		double sumofproducts = amount1value + amount2value;
		String total = checkout.productTotal.getText();

		total = total.substring(1);
		double totalvalue = Double.parseDouble(total);
		Assert.assertEquals(totalvalue, sumofproducts);
		test.log(Status.INFO, "Products sum and total value compared successfully");
		checkout.checkBoxClick().click();

		checkout.purchase.click();
		Thread.sleep(8000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}

		driver.context("WEBVIEW_com.androidsample.generalstore");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		driver.context("NATIVE_APP");
	}

	
}
