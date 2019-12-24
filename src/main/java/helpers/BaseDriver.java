package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseDriver {

	public AndroidDriver driver;
	
	@BeforeTest
	public AndroidDriver setAppDriver() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi"); //HAAZCY0141234JK (Asus device id), 47fa510f (MyDeviceRedmi), emulator-5554, 
		cap.setCapability(MobileCapabilityType.UDID,"4e5630f3");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		cap.setCapability("unicodekeyboard", true);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability("noReset", true);
		System.setProperty("webdriver.chrome.driver",Constants.chromeDriverPath);
		
		driver =  new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);	
		
		return driver;
	}
	
	
	@AfterTest
	public void endApp()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
}
