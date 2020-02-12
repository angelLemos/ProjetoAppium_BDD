package br.com.rsinet.hub_bdd.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	private static AndroidDriver<WebElement> driver;

	private DriverFactory() {
		
	}
	public static AndroidDriver<WebElement> iniciarDriver() throws MalformedURLException{
		if(driver == null)
			driver = inicializarDriver();
		return driver;
	}

	public static  AndroidDriver<WebElement> inicializarDriver() throws MalformedURLException {
			
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Angel");
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "9");
		desiredCapabilities.setCapability("appPackage", "com.Advantage.aShopping");
		desiredCapabilities.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
		desiredCapabilities.setCapability("unicodeKeyboard", true);
		desiredCapabilities.setCapability("resetKeyboard", true);

		if(driver == null) 
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static AndroidDriver<WebElement> fecharDriver() {
		if (driver != null) 
			driver.quit();
			return driver = null;
			
		}
	}


