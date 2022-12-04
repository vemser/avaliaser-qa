#language:pt

@test
Funcionalidade: Cadastrar Aluno

  Contexto: O usuario deve cadastrar aluno no sistema

  @smoke
  Cenario: Validar cadastro de aluno com sucesso
    Dado que faço login no sistema como gestor
    E que acesso a página de Cadastrar Aluno
    E que preencho o campo nome de aluno válido
    E que preencho o campo email de aluno válido
    E que seleciono uma trilha
    Quando clico em ‘Enviar’ para salvar cadastro de aluno
    Então devo visualizar mensagem de sucesso de aluno cadastrado e ser redirecionado para a página Dashboard


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