package pageObjects;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utils.CommonUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage {

	static AndroidDriver<AndroidElement> driver;

	public RegistrationPage(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'REGISTER')]")
    @CacheLookup
    private WebElement clickRegisterLink;
	
	@FindBy(name="firstName")
	private WebElement fnele;
	
	@FindBy(name="lastName")
	private WebElement lnele;
	
	@FindBy(name="phone")
	private WebElement pnele;
	
	@FindBy(name="userName")
	private WebElement emele;
	
	@FindBy(name="address1")
	private WebElement adele;
	
	@FindBy(name="state")
	private WebElement stele;

	@FindBy(name="register")
	private WebElement submit;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(name="register")
	private WebElement reg;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmpwd;
	
	@FindBy(xpath="//b[contains(text(),'Dear')]")
	private WebElement text;
	
	@FindBy(name="country") 
	private WebElement select;
	@FindBys( value = { @FindBy (tagName="option")})
	private List<WebElement> option;
	
	public void select_country(String s) {
		select.click();
		List<WebElement> list1=option;
		for(int i=0;i<list1.size();i++) {
			String country=list1.get(i).getText().toLowerCase().trim();
			System.out.println(country);
			if(s.equalsIgnoreCase(country)) {
				list1.get(i).click();
				break;
			}
			
		}
	}
	
	@FindBy(id="email")
	private WebElement username;
	
	

	public void clickRegister() {
		CommonUtils.click(clickRegisterLink,"Link");
	}
	
	
	
	
	public String validateText() {
		return text.getText();
	}
	
	public void RegistrationValues() {
		CommonUtils.enterText(fnele, "Meena");
		CommonUtils.enterText(lnele, "Nandish");
		CommonUtils.enterText(stele, "karnataka");
		CommonUtils.enterText(pnele, "987987987");
		CommonUtils.enterText(emele, "user@gmail.com");
		CommonUtils.enterText(adele, "Bangalore");
		CommonUtils.enterText(username, "meena");
		CommonUtils.enterText(pwd,"mercury");
		CommonUtils.enterText(confirmpwd, "mercury");
		CommonUtils.enterKeys(confirmpwd, Keys.ENTER);
		
	
		
	}
}
		

	



