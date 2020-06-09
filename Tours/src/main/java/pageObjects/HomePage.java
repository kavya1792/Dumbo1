package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	static AndroidDriver<AndroidElement> driver;

	public HomePage(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> productNames;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCartBtn;

	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public  WebElement cartButton;
	
	
	
	public void productNames(String value) throws InterruptedException {

		String productName = "";

		int count = productNames.size();

		for (int i = 0; i <= count; i++) {
			productName = productNames.get(i).getText();

			if (productName.equalsIgnoreCase(value)) {
				System.out.println("Product is displayed and it is added to cart");
				addToCartBtn.get(i).click();
				break;
			} else {
				System.out.println("Product is not displayed");
			}
		}

	}
	

}
