package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaProdutosObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//android.widget.TextView[starts-with(@text,'HP PAVILION 15Z TOUCH LAPTOP')]")
	private WebElement lnkEscolherProdutoLupa;
	
	@FindBy(xpath = "//android.widget.TextView[starts-with(@text,'HP ROAR MINI WIRELESS SPEAKER')]")
	private WebElement lnkEscolherProdutoTela;

	@FindBy(xpath = "//android.widget.TextView[starts-with(@text,'HP H2310 IN-EAR HEADSET')]")
	private WebElement lnkClicaNoFoneNaTelaProdutos;
	
	@FindBy(id =  "com.Advantage.aShopping:id/linearLayoutProductQuantity")
	private WebElement btnClicarEmQuantidades;

	@FindBy(id = "com.Advantage.aShopping:id/textViewProductQuantity")
	private WebElement lnkAlterarQuantidade;

	@FindBy(xpath = "//android.widget.TextView[starts-with(@text,'SPEAKERS')]")
	private WebElement lnkClicarEmCategoriaHome;

	@FindBy(id = "com.Advantage.aShopping:id/textViewApply")
	private WebElement btnConfirmarQuantidade;

	@FindBy(id = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement btnAdicionarNoCarrinho;

	public TelaProdutosObject(AndroidDriver<WebElement> driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void escolherProdutoNaTelaDeProduto() {
		lnkEscolherProdutoLupa.click();

	}
	
	public void escolherProdutoNaTelaDeProdutoHome() {
		lnkEscolherProdutoTela.click();

	}

	public void clicarEmQuantidade() {
		wait.until(ExpectedConditions.visibilityOf(btnClicarEmQuantidades));
		btnClicarEmQuantidades.click();
	}

	public void alterarQuantidades(String digiteAQuantidade) {
		
		lnkAlterarQuantidade.clear();
		lnkAlterarQuantidade.sendKeys(digiteAQuantidade);
	}

	public void confirmarQuantidadeDeProdutos() {

		wait.until(ExpectedConditions.visibilityOf(btnConfirmarQuantidade));
		btnConfirmarQuantidade.click();
	}

	public void adicionarNoCarrinho() {
		wait.until(ExpectedConditions.visibilityOf(btnAdicionarNoCarrinho));
		btnAdicionarNoCarrinho.click();
	}
	
	public void clicarNoFone() {
		lnkClicaNoFoneNaTelaProdutos.click();
	}

}
