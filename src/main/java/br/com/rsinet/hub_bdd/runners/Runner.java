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
	
		//exibir a saída do console de maneira legível
		monochrome = true
//
////		snippets = SnippetType.CAMELCASE,
//		//verifica se todas as etapas possuem a   definição de etapa
//		dryRun = false,
//
//        //falhará na execução se houver etapas indefinidas ou pendentes
//		strict = false
		)

public class Runner {

}
