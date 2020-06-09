package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConformationPage {
	
	private WebDriver driver;
	
	public ConformationPage(WebDriver driver) {
		this.setDriver(driver);
	}
	@FindBy(xpath="//b[contains(text(),'Dear')]")
	private WebElement text;
	
	public String get_Message() {
		
		return text.getText();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
}
