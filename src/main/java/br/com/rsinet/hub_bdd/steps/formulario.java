package br.com.rsinet.hub_bdd.steps;

import static br.com.rsinet.hub_bdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_bdd.utils.DriverFactory.inicializarDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.TelaObject.TelaFormularioObject;
import br.com.rsinet.hub_bdd.TelaObject.TelaInicialObject;
import br.com.rsinet.hub_bdd.TelaObject.TelaLoginObject;
import br.com.rsinet.hub_bdd.TelaObject.TelaMenuObject;
import br.com.rsinet.hub_bdd.utils.Scroll;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class formulario {

	private AndroidDriver<WebElement> driver;
	private TelaInicialObject telaInicial;
	private TelaMenuObject telaMenu;
	private TelaLoginObject telaLogin;
	private TelaFormularioObject telaFormulario;
	private WebDriverWait wait;
	private Scroll scrollTela;
	
	@Dado("^que usuario esta na pagina inicial do aplicativo Advantage$")
	public void que_usuario_esta_na_pagina_inicial_do_aplicativo_Advantage() throws Throwable {

		driver = inicializarDriver();
		
		telaInicial = new TelaInicialObject(driver);
		telaMenu = new TelaMenuObject(driver);
		telaLogin = new TelaLoginObject(driver);
		telaFormulario = new TelaFormularioObject(driver);
		
		scrollTela = new Scroll(driver);
		wait = new WebDriverWait(driver, 10);

	}

	@Quando("^clicar em botao de menu$")
	public void clicar_em_botao_de_menu() throws Throwable {
		telaInicial.clicarMenu();

	}

	@Quando("^clicar em login$")
	public void clicar_em_login() throws Throwable {
		telaMenu.clicarLogin();
	}

	@Quando("^clicar em criar conta$")
	public void clicar_em_criar_conta() throws Throwable {
		telaLogin.clicarNovaConta();
	}

	@Quando("^insere nome de usuario \"([^\"]*)\"$")
	public void insere_nome_de_usuario(String userName) throws Throwable {
	    telaFormulario.inserirUserName(userName);
	}

	@Quando("^insere o email \"([^\"]*)\"$")
	public void insere_o_email(String email) throws Throwable {
	   telaFormulario.inserirEmail(email);
	}

	@Quando("^insere a senha \"([^\"]*)\"$")
	public void insere_a_senha(String senha) throws Throwable {
	    telaFormulario.inserirSenha(senha);
	}

	@Quando("^confirma a senha \"([^\"]*)\"$")
	public void confirma_a_senha(String confirmSenha) throws Throwable {
	   telaFormulario.confirmarSenha(confirmSenha);
	}

	@Quando("^insere o primeiro nome \"([^\"]*)\"$")
	public void insere_o_primeiro_nome(String nome) throws Throwable {
	    telaFormulario.inserirNome(nome);
	}

	@Quando("^insere o ultimo nome \"([^\"]*)\"$")
	public void insere_o_ultimo_nome(String sobrenome) throws Throwable {
	    telaFormulario.inserirSobrenome(sobrenome);
	}

	@Quando("^insere o numero do telefone \"([^\"]*)\"$")
	public void insere_o_numero_do_telefone(String telefone) throws Throwable {
	    telaFormulario.inserirTelefone(telefone);
	}

	@Quando("^seleciona o pais \"([^\"]*)\"$")
	public void seleciona_o_pais(String pais) throws Throwable {
		 scrollTela.scroll("ADDRESS");
	     telaFormulario.selecionarPais(driver, pais);
	}

	@Quando("^insere a cidade \"([^\"]*)\"$")
	public void insere_a_cidade(String cidade) throws Throwable {
	  telaFormulario.inserirCidade(cidade);
	}

	@Quando("^insere o endereco \"([^\"]*)\"$")
	public void insere_o_endereco(String endereco) throws Throwable {
		
	    telaFormulario.inserirEndereco(endereco);
	}

	@Quando("^insere o estado \"([^\"]*)\"$")
	public void insere_o_estado(String estado) throws Throwable {
	    telaFormulario.inserirEstado(estado);
	}

	@Quando("^insere o CEP \"([^\"]*)\"$")
	public void insere_o_CEP(String cep) throws Throwable {
	   telaFormulario.inserirCep(cep);
	}
	@Quando("^clicar em registrar$")
	public void clicar_em_registrar() throws Throwable {
		telaFormulario.registrar();
	}

	@Quando("^clicar em menu para verificar usuario logado$")
	public void clicar_em_menu_para_verificar_usuario_logado() throws Throwable {
		telaInicial.clicarMenu();
	}
	
	@Entao("^usuario cadastrado com sucesso \"([^\"]*)\"$")
	public void usuario_cadastrado_com_sucesso(String userName) throws Throwable {
		WebElement element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), userName);
	}

	@Entao("^verificar se botao registrar esta desabilitado$")
	public void verificar_se_botao_registrar_esta_desabilitado() throws Throwable {
		scrollTela.scroll("REGISTER");
		assertFalse(telaFormulario.verificarSeRegistrarEstaDisponivel());
	}
	
	@After
	public void finaliza() {
		fecharDriver();
	}

}
