#language:pt

@test
Funcionalidade: Pagina Principal Instrutor

  Contexto: O usuario deve acessar página principal de Administrador

  @error
  Cenario: Validar cadastro de feedback com sucesso
    Dado que faço login no sistema como instrutor
    E que acesso a página de Cadastrar Feedback
    E preencho campo descrição de feedback válido
    E seleciono todos os campos válidos
    Quando clico em enviar feedback
    Então devo validar mensagem de Feedback cadastrado com sucesso

  @smoke
  Cenario: Validar tentativa de cadastro de feedback sem preencher descrição
    Dado que faço login no sistema como instrutor
    E que acesso a página de Cadastrar Feedback
    Quando clico em enviar feedback
    Então devo visualizar mensagem de erro para descrição de feedback vazia

  @error
  Cenario: Validar tentativa de cadastro de feedback sem selecionar campos obrigatórios
    Dado que faço login no sistema como instrutor
    E que acesso a página de Cadastrar Feedback
    E preencho campo descrição de feedback válido
    Quando clico em enviar feedback
    Então devo visualizar mensagem de erro para selecionar campos obrigatórios