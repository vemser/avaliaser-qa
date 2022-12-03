#language:pt

@test
Funcionalidade: Editar Colaborador

  Contexto: O usuario deve editar colaborador no sistema

  @ok
  Cenario: Validar edição de colaborador com sucesso
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Colaborador
    E que altero o campo nome válido
    E que altero o campo email válido
    Quando clico em ‘Editar’
    Então devo visualizar mensagem de confirmação de edição e ser redirecionado para a página Dashboard

  @smoke
  Cenario: Validar tentativa de edição de colaborador com nome inválido
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Colaborador
    E que altero o campo nome inválido
    E que altero o campo email válido
    Quando clico em ‘Editar’
    Então devo visualizar mensagem de erro para editar nome inválido

  @smoke
  Cenario: Validar tentativa de edição de colaborador sem preencher nome
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Colaborador
    E que altero o campo nome para vazio
    E que altero o campo email válido
    Quando clico em ‘Editar’
    Então devo visualizar mensagem de erro para editar nome vazio

  @smoke
  Cenario: Validar tentativa de edição de colaborador com email inválido
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Colaborador
    E que altero o campo nome válido
    E que altero o campo email inválido
    Quando clico em ‘Editar’
    Então devo visualizar mensagem de erro para editar email inválido

  @smoke
  Cenario: Validar tentativa de edição de colaborador com email vazio
    Dado que faço login no sistema como administrador
    E que acesso a página de Editar Colaborador
    E que altero o campo nome válido
    E que altero o campo email para vazio
    Quando clico em ‘Editar’
    Então devo visualizar mensagem de erro para editar email vazio






