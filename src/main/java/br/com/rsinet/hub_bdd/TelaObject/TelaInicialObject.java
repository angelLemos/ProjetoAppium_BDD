package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaInicialObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement btnClicarMenu;

	@FindBy(id = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement btnEscreverLupa;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement btnClicarLupa;

	@FindBy(xpath = "//android.widget.TextView[starts-with(@text,'HEADPHONES')]")
	private WebElement lnkClicarEmCategoriaHome;

	public TelaInicialObject(AndroidDriver<WebElement> driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void escreverLupa(String produto) {
		btnEscreverLupa.click();
		btnEscreverLupa.sendKeys(produto);

	}

	public void clicarLupa() {
		btnClicarLupa.click();

	}

	public void clicarMenu() {
		wait.until(ExpectedConditions.visibilityOf(btnClicarMenu));
		btnClicarMenu.click();

	}

	public void clicarProdutoTela() {

		lnkClicarEmCategoriaHome.click();

	}

}
