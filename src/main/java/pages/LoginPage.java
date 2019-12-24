package pages;

import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.BaseDriver;
import helpers.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	AndroidDriver driver;

	public LoginPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@FindBy(className="button-md-button")
	private WebElement loginBtn;

	
	public void clickloginBtn(){
		if(loginBtn.isDisplayed() && loginBtn.isEnabled()) {
			loginBtn.click();
		}
	}
	
	
}
