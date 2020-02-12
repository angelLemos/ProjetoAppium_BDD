package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.inicializarDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.TelaObject.TelaInicialObject;
import br.com.rsinet.hub_bdd.TelaObject.TelaLoginObject;
import br.com.rsinet.hub_bdd.TelaObject.TelaMenuObject;
import br.com.rsinet.hub_bdd.TelaObject.TelaProdutosObject;
import br.com.rsinet.hub_bdd.utils.Scroll;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaHome {
	private AndroidDriver<WebElement> driver;
	private TelaInicialObject telaInicial;
	private TelaProdutosObject telaProduto;
	private TelaMenuObject telaMenu;
	private TelaLoginObject telaLogin;
	private Scroll scrollTela;
	private WebDriverWait wait;
	

	@Quando("^clicar na opcao desejada na tela home$")
	public void clicar_na_opcao_desejada_na_tela_home() throws Throwable {
		
		driver = inicializarDriver();
		
		telaInicial = new TelaInicialObject(driver);
		telaProduto = new TelaProdutosObject(driver);
		telaMenu = new TelaMenuObject(driver);
		telaLogin = new TelaLoginObject(driver);
		scrollTela = new Scroll(driver);
		
		scrollTela.scroll("SPEAKERS");
		wait = new WebDriverWait(driver, 20);
		
	}

	@Quando("^escolher produto desejado na lista de produtos$")
	public void escolher_produto_desejado_na_lista_de_produtos() throws Throwable {
	
		telaProduto.escolherProdutoNaTelaDeProdutoHome();
	}

	@Entao("^estou na tela da opcao escolhida$")
	public void estou_na_tela_da_opcao_escolhida() throws Throwable {
	
		WebElement element = driver.findElementById("com.Advantage.aShopping:id/textViewProductName");
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "HP ROAR MINI WIRELESS SPEAKER");
	}
	@Quando("^clicar no menu$")
	public void clicar_no_menu() throws Throwable {
	    driver = inicializarDriver();
		
		telaInicial = new TelaInicialObject(driver);
		telaProduto = new TelaProdutosObject(driver);
		telaMenu = new TelaMenuObject(driver);
		telaLogin = new TelaLoginObject(driver);
		scrollTela = new Scroll(driver);
		
		telaInicial.clicarMenu();
		wait = new WebDriverWait(driver, 20);
	}

	@Quando("^clicar em Login no menu$")
	public void clicar_em_Login_no_menu() throws Throwable {
	    telaMenu.clicarLogin();
	}

	@Quando("^inserir usuario e senha \"([^\"]*)\" , \"([^\"]*)\"$")
	public void inserir_usuario_e_senha(String userName , String senha) throws Throwable {
	  telaLogin.clicarEmUserName(userName);
	  telaLogin.clicarEmPassword(senha);
	}

	@Quando("^clicar em logar$")
	public void clicar_em_logar() throws Throwable {
	   telaLogin.clicarEmLogin();
	}

	@Quando("^escolher categoria na tela inicial$")
	public void escolher_categoria_na_tela_inicial() throws Throwable {
	    telaInicial.clicarProdutoTela();
	}

	@Quando("^escolher produto$")
	public void escolher_produto() throws Throwable {
	   telaProduto.clicarNoFone();
	}

	@Quando("^alterar quantidade$")
	public void alterar_quantidade() throws Throwable {
	   telaProduto.clicarEmQuantidade();
	   telaProduto.alterarQuantidades("15");
	   telaProduto.confirmarQuantidadeDeProdutos();
	}

	@Quando("^adicionar no carrinho$")
	public void adicionar_no_carrinho() throws Throwable {
	   telaProduto.adicionarNoCarrinho();
	}

	@Entao("^constata que a limitacao na quantidade$")
	public void constata_que_a_limitacao_na_quantidade() throws Throwable {
		Assert.assertTrue(driver.getPageSource().contains("10"));
	}

}
