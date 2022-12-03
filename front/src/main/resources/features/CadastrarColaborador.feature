#language:pt

@test
Funcionalidade: Cadastrar Colaborador

  Contexto: O usuario deve cadastrar colaborador no sistema

  @error
  Cenario: Validar cadastro de colaborador sem foto com sucesso
    Dado que faço login no sistema como administrador
    E que acesso a página de Cadastrar Colaborador
    E que preencho o campo nome válido
    E que preencho o campo email válido
    E que seleciono um cargo
    Quando clico em ‘Enviar’
    Então devo visualizar mensagem de sucesso na tela e ser redirecionado para a página Dashboard

  @smoke
  Cenario: Validar tentativa de cadastro de colaborador preenchendo nome inválido
    Dado que faço login no sistema como administrador
    E que acesso a página de Cadastrar Colaborador
    E que preencho o campo nome inválido
    E que preencho o campo email válido
    E que seleciono um cargo
    Quando clico em ‘Enviar’
    Então devo visualizar mensagem de erro para nome ou email na tela

  @smoke
  Cenario: Validar tentativa de cadastro de colaborador sem preencher nome
    Dado que faço login no sistema como administrador
    E que acesso a página de Cadastrar Colaborador
    E que preencho o campo email válido
    E que seleciono um cargo
    Quando clico em ‘Enviar’
    Então devo visualizar mensagem de erro para nome vazio

  @smoke
  Cenario: Validar tentativa de cadastro de colaborador preenchendo email inválido
    Dado que faço login no sistema como administrador
    E que acesso a página de Cadastrar Colaborador
    E que preencho o campo nome válido
    E que preencho o campo email inválido
    E que seleciono um cargo
    Quando clico em ‘Enviar’
    Então devo visualizar mensagem de erro para email inválido

  @smoke
  Cenario: Validar tentativa de cadastro de colaborador sem preencher email
    Dado que faço login no sistema como administrador
    E que acesso a página de Cadastrar Colaborador
    E que preencho o campo nome válido
    E que seleciono um cargo
    Quando clico em ‘Enviar’
    Então devo visualizar mensagem de erro para email vazio

  @smoke
  Cenario: Validar tentativa de cadastro de colaborador sem selecionar cargo
    Dado que faço login no sistema como administrador
    E que acesso a página de Cadastrar Colaborador
    E que preencho o campo nome válido
    E que preencho o campo email válido
    Quando clico em ‘Enviar’
    Então devo visualizar mensagem de erro para cargo vazio







