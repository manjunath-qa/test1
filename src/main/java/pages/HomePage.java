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

public class HomePage {

	AndroidDriver driver;

	public HomePage(AndroidDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div/a")
	private WebElement downloadAppBtn;

	@AndroidFindBy(id="com.android.chrome:id/positive_button")
	private MobileElement continueOption;

	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private MobileElement allowOption;

	@AndroidFindBy(id="com.android.chrome:id/button_primary")
	private MobileElement okOption;

	public void clickDownloadAppBtn(){
		downloadAppBtn.click();
	}
	public void clickContinueDownloadOption(){
		continueOption.click();
	}
	public void clickAllowOption(){
		allowOption.click();
	}
	public void clickOKOption(){
		okOption.click();
	}


}
