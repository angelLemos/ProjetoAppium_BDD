package br.com.rsinet.hub_bdd.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue= {"br.com.rsinet.hub_bdd.steps"},
		tags = {"@pesquisarProdutoPelaHome , @validarQuantidadeDeProdutos"},
	//	plugin = {"pretty" , "com.cucumber.listener.ExtentCucumberFormatter:target/reportTestes.html"},
	
		//exibir a sa�da do console de maneira leg�vel
		monochrome = true
//
////		snippets = SnippetType.CAMELCASE,
//		//verifica se todas as etapas possuem a   defini��o de etapa
//		dryRun = false,
//
//        //falhar� na execu��o se houver etapas indefinidas ou pendentes
//		strict = false
		)

public class Runner {

}
