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

public class RegisterPage {

	AndroidDriver driver;

	public RegisterPage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@FindBy(className="registerbtn")
	private WebElement registerHomeBtn;

	@FindBy(className="button-inner")
	private WebElement registerBtn;


	public void clickRegisterHomeBtn(){
		registerHomeBtn.click();
	}


	public void clickRegisterBtn(){
		if(registerBtn.isDisplayed() && registerBtn.isEnabled()) {
			registerBtn.click();
		}
	}


	public String randomEmailGenerator() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		return ("username"+ randomInt +"@gmail.com"); 
	}

	public String randomPasswordGenerator() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  

		return ("Password"+ randomInt); 
	}

}
