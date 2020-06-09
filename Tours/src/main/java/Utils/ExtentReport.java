package Utils;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class ExtentReport {

	
	protected  static ExtentReports ext; 

 

	@BeforeSuite
	public void Report() {
		ExtentHtmlReporter report = new ExtentHtmlReporter(".\\" + "Reports" + ".html");
		report.config().setDocumentTitle("Automation Report");
		report.config().setReportName("Functional Testing: newtours.demoaut");
		report.config().setTheme(Theme.DARK);

		ext = new ExtentReports();
		ext.attachReporter(report);

		ext.setSystemInfo("Host Name", "Local Host");
		ext.setSystemInfo("Environemnt", "QA");
		ext.setSystemInfo("user", "Meena");
	}

	
	

}
