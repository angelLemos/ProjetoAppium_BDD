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

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")
	private WebElement txtInserirUserName;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText")
	private WebElement txtInserirSenha;

	@FindBy(id = "com.Advantage.aShopping:id/buttonLogin")
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
		wait.until(ExpectedConditions.visibilityOf(txtInserirUserName));
		txtInserirUserName.click();
		txtInserirUserName.sendKeys(userName);
	}

	public void clicarEmPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(txtInserirSenha));
		txtInserirSenha.click();
		txtInserirSenha.sendKeys(password);

	}

	public void clicarEmLogin() {
		btnClicarEmLogin.click();

	}

}
