package pageObjects;

import java.io.FileNotFoundException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage  {

	

		static AndroidDriver<AndroidElement> driver;

		public LoginPage(AndroidDriver<AndroidElement> driver) {

			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@FindBy(name="userName")
		private WebElement userName;
		
		@FindBy(name="password")
		private WebElement password;
		
		@FindBy(name="login")
		private WebElement submit;
		
	@FindBy(xpath="//a[contains(text(),'SIGN-ON')]")
	private WebElement validateText;
		
	@FindBy(xpath="//a[@href='mercurysignoff.php']")
	private WebElement signoff;
	
		public void enterPassword(String pwd) {
	
			CommonUtils.enterText(password,pwd);
			//CommonUtils.enterKeys(password,Keys.ENTER);
		}

		

		public void enterCredentilas() throws FileNotFoundException {
			String username = CommonUtils.getPropertyValue("homepage", "email");
			String passWord=CommonUtils.getPropertyValue("homepage", "password");
			CommonUtils.enterText(userName,username);
			CommonUtils.enterText(password, passWord);
			CommonUtils.enterKeys(password,Keys.ENTER);
		
		}
		
		public void enterInvalidCredentilas() throws FileNotFoundException {
			String username = CommonUtils.getPropertyValue("homepage", "email");
			String invalidpassword = CommonUtils.getPropertyValue("homepage", "invalidpwd");
			CommonUtils.enterText(userName,username);
			CommonUtils.enterText(password, invalidpassword);
			CommonUtils.enterKeys(password,Keys.ENTER);
		
		}
		
		
		public String textValidation() {
			return validateText.getText();
		}
		
		public String clickSignoff() {
			
			return signoff.getText();
		}
}
		