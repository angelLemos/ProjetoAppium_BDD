package br.com.rsinet.hub_bdd.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll {
	
	private TouchAction touch;
	private static AndroidDriver<WebElement> driver;

	public Scroll(AndroidDriver<WebElement> driver) {
		
		this.driver = driver;
		this.touch =  new TouchAction (this.driver);
	}

	public void scroll(String texto) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))")
				.click();
	}
	
	public static AndroidDriver<WebElement> scrollTelaInicial () {
		
		(new TouchAction((PerformsTouchActions) driver)).press(PointOption.point(1055, 378))
        .moveTo(PointOption.point(1059, 1744)).release().perform();
       
        return driver;
	}

}
