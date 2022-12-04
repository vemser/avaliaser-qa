#language:pt

@test
Funcionalidade: Cadastrar Feedback

  Contexto: O usuario deve cadastrar Feedback

  @smoke
  Cenario: Validar tentativa de cadastro de feedback sem preencher descrição
    Dado que faço login no sistema como instrutor
    E que acesso a página de Cadastrar Feedback
    Quando clico em enviar feedback
    Então devo visualizar mensagem de erro para descrição de feedback vazia

  @smoke
  Cenario: Validar tentativa de cadastro de feedback sem selecionar campos obrigatórios
    Dado que faço login no sistema como instrutor
    E que acesso a página de Cadastrar Feedback
    E preencho campo descrição de feedback válido
    Quando clico em enviar feedback
    Então devo visualizar mensagem de erro para selecionar campos obrigatórios