package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonUtils extends FilePath {

	AndroidDriver<AndroidElement> driver;
	//protected static ExtentTest test;
public CommonUtils(AndroidDriver<AndroidElement>  driver) {

	this.driver=driver;
	
}  

	public void scrollToText(String text){

	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ text + "\"));").click();

}
	public static String getPropertyValue(String fileName, String key) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(get_path("Testdata") + "\\" + fileName + ".properties");
		Properties p = new Properties();
		try {
			p.load(fis);
			return p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	 public static void click(WebElement ele, String elementName) {
	        try {
	            ele.click();
	            ConfigClass.test.log(Status.INFO, "clicked on " + elementName.toString() + " element");
	        } catch (Exception e) {
	        	ConfigClass.test.log(Status.FAIL, "Failed to click on " + elementName.toString() +" element");
	        }

	 

	    }

	 

	    public static void enterText(WebElement ele, String value) {
	        try {
	            ele.sendKeys(value);
	            ConfigClass.test.log(Status.INFO, "entered " + value + " into text field");
	        } catch (Exception e) {
	        	ConfigClass.test.log(Status.FAIL, "Failed to enter" + value + " into text field");
	        }

	 

	    }
	    public static void enterKeys(WebElement ele,Keys enter) {
	        try {
	            ele.sendKeys(enter);
	            ConfigClass.test.log(Status.INFO, "entered " + enter + " into text field");
	        } catch (Exception e) {
	        	ConfigClass.test.log(Status.FAIL, "Failed to enter" + enter + " into text field");
	        }

	 

	    }


}