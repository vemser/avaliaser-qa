#language:pt

@test
Funcionalidade: Editar Usuário Logado

  Contexto: O usuario deve editar seu nome no sistema

  @smoke
  Cenario: Validar edição de usuário com sucesso
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Usuário admin
    E que altero o campo nome de usuário válido
    Quando clico em Editar nome
    Então devo visualizar mensagem de confirmação de edição de nome e ser redirecionado para a página Dashboard

  @smoke
  Cenario: Validar tentativa de edição de usuário com nome inválido
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Usuário admin
    E que altero o campo nome de usuário inválido
    Quando clico em Editar nome
    Então devo visualizar mensagem de erro para nome de usuário inválido

  @smoke
  Cenario: Validar tentativa de edição de usuário com nome vazio
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Usuário admin
    E que altero o campo nome de usuário para vazio
    Quando clico em Editar nome
    Então devo visualizar mensagem de erro para nome de usuário vazio