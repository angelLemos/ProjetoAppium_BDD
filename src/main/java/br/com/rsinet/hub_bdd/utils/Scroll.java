package br.com.rsinet.hub_bdd.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Scroll {

	private AndroidDriver<WebElement> driver;

	public Scroll(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	public void scroll(String texto) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))")
				.click();
	}

}
