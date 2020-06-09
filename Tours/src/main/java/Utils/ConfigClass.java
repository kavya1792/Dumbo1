package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ConfigClass extends ExtentReport {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	protected static ExtentTest test;
	public static DesiredCapabilities caps = new DesiredCapabilities();

	public static AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunning(4723);

		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerIsRunning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;

	}

	public static void startEmulator() throws IOException, InterruptedException {

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\startEmulator.bat";
		System.out.println(path);
		Runtime.getRuntime().exec(path);
		Thread.sleep(20000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

		String configPath = System.getProperty("user.dir") + "\\Testdata\\global.properties";
		FileInputStream fis = new FileInputStream(configPath);
		Properties prop = new Properties();
		prop.load(fis);

		prop.getProperty(appName);

		startEmulator();
		Thread.sleep(5000);

		if (appName.equalsIgnoreCase("GeneralStoreApp")) {

			File appDir = new File("src");
			File app = new File(appDir, "General-Store.apk");// Google Play Store.apk General-Store.apk
			caps.setCapability("deviceName", "Device");
			caps.setCapability("platformName", "Android");
			caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			caps.setCapability("deviceName", "Device");
			caps.setCapability("platformName", "Android");

			caps.setCapability(CapabilityType.APPLICATION_NAME, "General");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			caps.setCapability(CapabilityType.VERSION, "9");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
			caps.setCapability("noReset", true);
			driver = new AndroidDriver(caps);
			// driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		
		} else if (appName.equalsIgnoreCase("Url")) {

			caps.setCapability("deviceName", "Device");
			caps.setCapability("platformName", "Android");
			caps.setCapability(CapabilityType.APPLICATION_NAME, "MakeMyTrip");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			caps.setCapability(CapabilityType.VERSION, "9");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			//driver = new AndroidDriver(caps);
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			String URL = prop.getProperty("Url");
			System.out.println(URL);
			driver.get(URL);

		} else {
			System.out.println(appName + " is not found, please pass the correct browserName");
		}
		return driver;

	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
			String screenshotPath = Screenshot.takeScreenShot(this.driver, result.getName());
			Thread.sleep(5000);
			test.addScreenCaptureFromPath(screenshotPath); // report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			
		}

	}
	@AfterTest
	public void exit() {
	ext.flush();
}
	
}
