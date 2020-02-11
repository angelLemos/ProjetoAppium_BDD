# language: pt
Funcionalidade: Pesquisar produto tela inicial

Contexto: 
    Dado que usuario esta na pagina inicial do aplicativo Advantage
    
    @pesquisarProdutoPelaHome
    Cenario: Pesquisar produto pela tela home
    Quando clicar na opcao desejada na tela home
    E escolher produto desejado na lista de produtos
    Entao estou na tela da opcao escolhida
    
    @validarQuantidadeDeProdutos
    Esquema do Cenario: Certifica abertura de produto diferente
    Quando clicar no menu
    E clicar em Login no menu
    E inserir usuario e senha "<usuario>" , "<senha>" 
    E clicar em logar
    E escolher categoria na tela inicial 
    E escolher produto
    E alterar quantidade
    E adicionar no carrinho
    Entao constata que a limitacao na quantidade
    
    Exemplos:
    
    |usuario  |senha     | 
    |Angjokl89|Athena1234|       
    


