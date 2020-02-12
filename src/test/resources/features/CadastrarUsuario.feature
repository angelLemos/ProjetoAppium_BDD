#language: pt

Funcionalidade: Cadastrar Usuario

  Contexto: 
    Dado que usuario esta na pagina inicial do aplicativo Advantage
    Quando clicar em botao de menu
    E clicar em login
    E clicar em criar conta

    @CriarCadastroComSucesso
  	Esquema do Cenario: Cadastro com sucesso com dados validos
    E insere nome de usuario "<userName>"
    E insere o email "<email>"
    E insere a senha "<senha>"
    E confirma a senha "<senhaConfirm>"
    E insere o primeiro nome "<primeiroNome>"
    E insere o ultimo nome "<ultimoNome>"
    E insere o numero do telefone "<telefone>"
    E seleciona o pais "<pais>"
    E insere a cidade "<cidade>"
    E insere o endereco "<endereco>"
    E insere o estado "<estado>"
    E insere o CEP "<CEP>"
    E clicar em registrar 
    E clicar em menu para verificar usuario logado 
    Entao usuario cadastrado com sucesso "<userName>"
    
    Exemplos:
    
      | userName | email           | senha      | senhaConfirm | primeiroNome | ultimoNome | telefone     | pais   | estado    | endereco    | cidade | CEP       |
      | Angjolpq9| athena@live.com | Athena1234 | Athena1234   | Athena       | Mel        | (13)967548903| Brazil | Sao Paulo | Av.Cons, 188| Santos | 11.787-889|

    @validarBotao
    Esquema do Cenario: Validar se o botao registrar esta desabilitado sem informacoes preenchidas
    E insere o email "<email>"
    Entao verificar se botao registrar esta desabilitado
    
    Exemplos: 
    
    |email           |
    |athena1@live.com| 
    
