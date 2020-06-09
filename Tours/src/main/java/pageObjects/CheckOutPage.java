package pageObjects;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {

	static AndroidDriver<AndroidElement> driver;

	public CheckOutPage(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	

	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productlist1;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productlist2;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	public WebElement checkBoxClick() {
		
		
		return checkBox;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement productTotal;
	
	@AndroidFindBy(xpath="//*[@text='Visit to the website to complete purchase']")
	public WebElement purchase;
	
	@AndroidFindBy(xpath="//input[@name='q']")
	private WebElement enterValue;
	
	public WebElement enterName() {
		return enterValue;
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text='Weather']")
	public WebElement weather;
}
