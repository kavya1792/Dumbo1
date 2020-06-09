package Utils;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Screenshot {
	
	public static AndroidDriver<AndroidElement> driver;

	public static String takeScreenShot(WebDriver wd,String Name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) wd;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path= FilePath.get_path("screenshots") + "\\"+Name+ ".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
}



