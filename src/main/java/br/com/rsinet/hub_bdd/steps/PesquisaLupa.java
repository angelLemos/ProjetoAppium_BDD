package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.inicializarDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.TelaObject.TelaInicialObject;
import br.com.rsinet.hub_bdd.TelaObject.TelaProdutosObject;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaLupa {
	
	private AndroidDriver<WebElement> driver;
	private TelaInicialObject telaInicial;
	private TelaProdutosObject telaProduto;
	private WebDriverWait wait;

	
	@Quando("^clicar na lupa$")
	public void clicar_na_lupa() throws Throwable {
		driver = inicializarDriver();
		telaInicial = new TelaInicialObject(driver);
		telaProduto = new TelaProdutosObject(driver);
		telaInicial.clicarLupa();
		wait = new WebDriverWait(driver, 10);
	}

	@Quando("^digitar o que deseja na lupa$")
	public void digitar_o_que_deseja_na_lupa() throws Throwable {
	  telaInicial.escreverLupa("Laptops");
	  telaInicial.clicarLupa();
	}

	@Quando("^selecionar produto desejado na lista de produtos$")
	public void selecionar_produto_desejado_na_lista_de_produtos() throws Throwable {
		telaProduto.escolherProdutoNaTelaDeProduto();
	}

	@Entao("^abre a pagina da opcao escolhida$")
	public void abre_a_pagina_da_opcao_escolhida() throws Throwable {
		assertTrue(driver.getPageSource().contains("HP PAVILION 15Z TOUCH LAPTOP"));
	}

	@Quando("^digitar um produto inexistente$")
	public void digitar_um_produto_inexistente() throws Throwable {
	   telaInicial.escreverLupa("smartphones");
	   telaInicial.clicarLupa();
	}

	@Entao("^constata que o produto nao existe$")
	public void constata_que_o_produto_nao_existe() throws Throwable {
		WebElement element = driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "- No results for \"smartphones\" -");
	}


}
