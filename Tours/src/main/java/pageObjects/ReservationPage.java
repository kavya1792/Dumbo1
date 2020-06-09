package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utils.CommonUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class ReservationPage {
	static AndroidDriver<AndroidElement> driver;

	public ReservationPage(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath = "//font/font[contains(text(),'Flight')]")
	private WebElement geth;

	public String get_actualHeading() {
		return geth.getText();
	}

	@FindBy(xpath = "//font/font[contains(text(),'Pre')]")
	private WebElement geth2;

	public String get_actualHeading2() {
		return geth2.getText();
	}

	@FindBy(xpath = "//a[text()='ITINERARY']")
	private WebElement ititab;

	public void click_itinerarytab() {
		ititab.click();
	}

	@FindBy(xpath = "(//img)[5]")
	private WebElement findFlighter;

	public boolean validatefindFlighter() {
		return findFlighter.isDisplayed();
	}

	@FindBy(xpath = "//input[@value='oneway']")
	private WebElement tripValue;

	public void click_radio() {
		tripValue.click();
	}

	@FindBy(xpath = "//select[@name='passCount']")
	private WebElement pass;

	@FindBy(xpath = "//select[@name='fromPort']")
	private WebElement fromport;

	@FindBy(xpath = "//select[@name='fromMonth']")
	private WebElement fromMonth;

	@FindBy(xpath = "//select[@name='fromDay']")
	private WebElement fromday;

	@FindBy(xpath = "//select[@name='toPort']")
	private WebElement dest;

	@FindBy(xpath = "//select[@name='toMonth']")
	private WebElement toMonth;

	@FindBy(xpath = "//select[@name='toDay']")
	private WebElement toDay;

	@FindBy(xpath = "//select[@name='airline']")
	public WebElement serviceclass;

	public void dropdown() {

		Select s = new Select(pass);
		s.selectByValue("2");

		Select depart = new Select(fromport);
		depart.selectByValue("London");

		Select fromMon = new Select(fromMonth);
		fromMon.selectByValue("3");

		Select fromDay = new Select(fromday);
		fromDay.selectByValue("3");

		Select toPort = new Select(dest);
		toPort.selectByValue("New York");

		Select toMon = new Select(toMonth);
		toMon.selectByValue("3");

		Select toDate = new Select(toDay);
		toDate.selectByValue("3");

		Select serviceclasses = new Select(serviceclass);
		serviceclasses.selectByVisibleText("Unified Airlines");
	}

	@FindBy(xpath = "//input[@value='Business']")
	public WebElement Business;

	public void click_checks() {
		CommonUtils.click(Business, "Business selected");
	}

	@FindBy(xpath = "//select[@name='airline']")
	private WebElement airline;

	public void click_check() {
		Select air = new Select(airline);
		air.selectByValue("Unified Airlines");
	}

	@FindBy(xpath = "//input[@name='findFlights']")
	private WebElement submit;

	public void click_submit() {
		CommonUtils.click(submit,"Clicked on Submit button");
	}

	@FindBy(xpath = "(//table/tbody/tr[1]/td/img)[2]")
	private WebElement selectFlight;

	public boolean validateselectFlight() {
		return selectFlight.isDisplayed();
	}

	@FindBy(xpath = "//input[@value='Blue Skies Airlines$360$270$5:03']")
	private WebElement depart;

	public void click_radiodepart() {
		CommonUtils.click(depart,"Department selected");
	}

	@FindBy(xpath = "//input[@value='Pangea Airlines$632$282$16:37']")
	private WebElement arrival;

	public void click_radioreturn() {
		CommonUtils.click(arrival,"Selected Arrival");
	}

	@FindBy(xpath = "//input[@name='reserveFlights']")
	private WebElement clickflight;

	public void click_clickflight() {
		CommonUtils.click(clickflight,"Clikcked on Flight");
	}

	@FindBy(xpath = "//input[@name='passFirst0']")
	private WebElement firstName;

	public void firstName() {
		CommonUtils.enterText(firstName,"Meena");
	}

	@FindBy(xpath = "//input[@name='passLast0']")
	private WebElement lastName;

	public void lastName() {
		CommonUtils.enterText(lastName,"Nandish");
	}

	@FindBy(xpath = "//select[@name='pass.0.meal']")
	private WebElement meal;

	public void dropdownMeal() {
		Select s = new Select(meal);
		s.selectByValue("HNML");
	}

	@FindBy(xpath = "//select[@name='creditCard']")
	private WebElement creditCard;

	public void dropdownCredit() {
		Select s = new Select(creditCard);
		s.selectByValue("BA");
	}

	@FindBy(xpath = "//input[@name='creditnumber']")
	private WebElement creditNum;

	public void creditNum() {
		CommonUtils.enterText(creditNum,"6494786");
	}

	@FindBy(xpath = "//select[@name='cc_exp_dt_mn']")
	private WebElement creditMonth;

	public void dropdownCreditMonth() {
		Select s = new Select(creditMonth);
		s.selectByIndex(3);
	}

	@FindBy(xpath = "//select[@name='cc_exp_dt_yr']")
	private WebElement creditYear;

	public void dropdownCreditYear() {
		Select s = new Select(creditYear);
		s.selectByValue("2008");
	}

	@FindBy(xpath = "//input[@name='cc_frst_name']")
	private WebElement creditFname;

	public void creditFname() {
		CommonUtils.enterText(creditFname,"Meena");
	}

	@FindBy(xpath = "//input[@name='cc_mid_name']")
	private WebElement creditMname;

	public void creditMname() {
		CommonUtils.enterText(creditMname,"Venkat");
	}

	@FindBy(xpath = "//input[@name='cc_last_name']")
	private WebElement creditLname;

	public void creditLname() {
		CommonUtils.enterText(creditLname,"Raju");
	}

	@FindBy(xpath = "(//input[@name='ticketLess'])[1]")
	private WebElement ticketLess;

	public void ticketLess() {
		CommonUtils.click(ticketLess,"Selected ticketless");
	}

	@FindBy(xpath = "(//input[@name='ticketLess'])[2]")
	private WebElement billAddress;

	public void checkbillAddress() {
		CommonUtils.click(billAddress,"Address");
	}

	@FindBy(xpath = "//input[@name='billAddress1']")
	private WebElement billAddr;

	public boolean validatebillAddr() {
		return billAddr.isDisplayed();
	}

	@FindBy(xpath = "//input[@name='billCity']")
	private WebElement billCity;

	public boolean validatebillCity() {
		return billCity.isDisplayed();
	}

	@FindBy(xpath = "//input[@name='billState']")
	private WebElement billState;

	public boolean validatebillState() {
		return billState.isDisplayed();
	}

	@FindBy(xpath = "//input[@name='billZip']")
	private WebElement billZip;

	public WebElement validatebillZip() {
		 billZip.isDisplayed();
		billZip.sendKeys(Keys.ENTER);
		return billZip;
	}

	@FindBy(xpath = "//select[@name='billCountry']")
	private WebElement billCountry;

	public void dropdownbillCountry() {

		Select s = new Select(billCountry);
		s.selectByVisibleText("AUSTRALIA");
		CommonUtils.enterKeys(billCountry, Keys.TAB);
		CommonUtils.enterKeys(billCountry,Keys.ENTER);
	}

	@FindBy(xpath = "//input[@type='image']")
	private WebElement buyFlights;

	public void click_buyFlights() {
		buyFlights.click();
	}
	
	@FindBy(xpath = "//font[contains(text(),'itinerary has been booked!')]")
	private WebElement message;
	
	public boolean flightBookingConformationMsg() {
		return message.isDisplayed();
	}
	
	@FindBy(xpath="//img[@src='/images/forms/Logout.gif']")
	private WebElement logout;
	
	public void clickLogOut() {
		logout.click();
	}
}


