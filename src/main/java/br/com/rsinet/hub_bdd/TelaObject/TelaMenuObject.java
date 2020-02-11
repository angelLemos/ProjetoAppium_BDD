package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaMenuObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@FindBy(id = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement lnkClicarLogin;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement btnClicarMenu;

	public TelaMenuObject(AndroidDriver<WebElement> driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void clicarLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(btnClicarMenu));
		lnkClicarLogin.click();
	}

}
