package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaLoginObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@FindBy(id = "com.Advantage.aShopping:id/textViewDontHaveAnAccount")
	private WebElement lnkCriarConta;

	@FindBy(id = "//android.widget.TextView[starts-with(@text,'USER NAME')]")
	private WebElement txtInserirUserName;

	@FindBy(id = "//android.widget.TextView[starts-with(@text,'PASSWORD')]")
	private WebElement txtInserirSenha;

	@FindBy(id = "//android.widget.Button[starts-with(@text, 'LOGIN')]")
	private WebElement btnClicarEmLogin;

	public TelaLoginObject(AndroidDriver<WebElement> driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void clicarNovaConta() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkCriarConta));
		lnkCriarConta.click();
	}

	public void clicarEmUserName(String userName) {
		txtInserirUserName.click();
		txtInserirUserName.sendKeys(userName);
//			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText\r\n" + 
//					"").click();
//			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText\r\n" + 
//					"").sendKeys(userName);
	}

	public void clicarEmPassword(String password) {
		txtInserirSenha.click();
		txtInserirSenha.sendKeys(password);
//			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText\r\n" + 
//					"").click();
//			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText\r\n" + 
//					"").sendKeys(password);

	}

	public void clicarEmLogin() {
		btnClicarEmLogin.click();

	}

}
