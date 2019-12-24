package testcases;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.BaseDriver;
import helpers.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.asm.Advice.Enter;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class howzat_testcase1{

	BaseDriver base = new BaseDriver();
	AndroidDriver<WebElement> driver ;

	Map<Object,Object> map=new HashMap<Object,Object>();
	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;

	@BeforeTest
	public void launchBrowser()throws MalformedURLException {
		driver = base.setAppDriver();
		driver.get(Constants.URL);
	}

	@Test(priority=1)
	public void downloadHowzatApp() throws InterruptedException, MalformedURLException {

		homePage = new HomePage(driver);
		System.out.println("driver initialised at home page: "+driver);

		homePage.clickDownloadAppBtn();
		Thread.sleep(2000);

		driver.context("NATIVE_APP");

		homePage.clickContinueDownloadOption();
		homePage.clickAllowOption();

		Thread.sleep(2000);

		homePage.clickOKOption();

		System.out.println("App downloaded successfully...");
		driver.context("CHROMIUM");
		Thread.sleep(1000);
		
	}


	@Test(priority=2)
	public void registerUser() throws MalformedURLException, InterruptedException
	{	
		registerPage = new RegisterPage(driver);
		System.out.println("driver initialised at registration page: "+driver);
		
		Thread.sleep(2000);
		
		registerPage.clickRegisterHomeBtn();
		Thread.sleep(4000);

		List<WebElement> signUpForm=driver.findElements(By.className("text-input-md"));

		map.put(registerPage.randomEmailGenerator(), registerPage.randomPasswordGenerator());

		for ( Map.Entry<Object,Object> entry : map.entrySet()) {
			signUpForm.get(0).click();
			signUpForm.get(0).sendKeys(entry.getKey().toString());
			signUpForm.get(1).click();
			signUpForm.get(1).sendKeys(entry.getValue().toString());

		}

		registerPage.clickRegisterBtn();
		Thread.sleep(2000);
		System.out.println("User registered successfully...");

		Thread.sleep(2000);
		driver.quit();
		Thread.sleep(1000);
	}


	@Test(priority=3)
	public void loginUser() throws MalformedURLException, InterruptedException {

		launchBrowser();
		Thread.sleep(2000);

		loginPage = new LoginPage(driver);
		System.out.println("driver initialised at login page: "+driver);
		
		driver.findElement(By.xpath("//*[@id=\"top-bg\"]/div[1]/div[2]/div[2]")).click();

		Thread.sleep(2000);

		List<WebElement> loginForm=driver.findElements(By.className("text-input-md"));
		for ( Map.Entry<Object,Object> entry : map.entrySet()) {
			loginForm.get(0).click();
			loginForm.get(0).sendKeys(entry.getKey().toString());
			loginForm.get(1).click();
			loginForm.get(1).sendKeys(entry.getValue().toString());
		}

		loginPage.clickloginBtn();

		System.out.println("User logged in successfully...");
	}


}
