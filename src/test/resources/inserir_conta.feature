# language: pt
@Funcionais
Funcionalidade: Cadastro de contas
  Como um usuário
  Eu quero cadastrar contas
  Para poder distribuir meu dinheiro de uma forma mais organizada

  #Background
  Contexto:
    Dado que desejo adicionar uma conta
    #Dado que estou acessando a aplicação
    #Quando informo o usuário "emersondms@hotmail.com"
    #E a senha "emersondms"
    #E seleciono entrar
    #Então visualizo a página inicial
    #Quando seleciono Contas
    #E seleciono Adicionar

  Esquema do Cenário: Deve validar regras cadastro contas
    Quando adiciono a conta "<conta>"
    #E seleciono Salvar
    Então recebo a mensagem "<mensagem>"

  Exemplos:
    | conta            | mensagem                           |
    | Conta de Teste   | Conta adicionada com sucesso!      |
    |                  | Informe o nome da conta            |
    | Conta mesmo nome | Já existe uma conta com esse nome! |