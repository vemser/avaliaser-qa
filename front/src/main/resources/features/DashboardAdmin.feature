#language:pt

@test
Funcionalidade: Dashboard Admin

  Contexto: O usuario deve acessar página principal de Administrador

  @smoke
  Cenario: Validar página Dashboard Administrador com sucesso
    Dado que faço login no sistema como administrador
    Então devo visualizar mensagem de boas-vindas e lista de colaboradores na tela

  @smoke
  Cenario: Validar botão ‘Cadastrar Colaborador’ com sucesso
    Dado que faço login no sistema como administrador
    E que clico em 'Menu'
    Quando clico em ‘Cadastrar Colaborador’
    Então devo ser redirecionado para a página de ‘Cadastrar Colaborador’

  @smoke
  Cenario: Validar visualizar detalhes colaborador com sucesso
    Dado que faço login no sistema como administrador
    Quando clico em um colaborador
    Então devo visualizar detalhes deste colaborador

  @smoke
  Cenario: Validar botão ‘Editar Colaborador’ com sucesso
    Dado que faço login no sistema como administrador
    Quando clico em ‘Editar Colaborador’
    Então devo ser redirecionado para a página de ‘Editar Colaborador’

  @ok
  Cenario: Validar botão ‘Deletar Colaborador’ com sucesso
    Dado que faço login no sistema como administrador
    E clico em ‘Deletar Colaborador’
    Quando clico em ‘Confirmar’
    Então devo visualizar mensagem de confirmação na tela

  @smoke
  Cenario: Validar botão ‘Trocar Senha’ com sucesso
    Dado que faço login no sistema como administrador
    E clico no ícone da foto de perfil admin
    Quando clico em ‘Trocar Senha’
    Então devo ser redirecionado para a página de ‘Alterar Senha’

  @smoke
  Cenario: Validar botão ‘Editar’ com sucesso
    Dado que faço login no sistema como administrador
    E clico no ícone da foto de perfil admin
    Quando clico em ‘Editar Usuário’
    Então devo ser redirecionado para a página de ‘Editar Usuário’

  @smoke
  Cenario: Validar botão ‘Sair’ com sucesso
    Dado que faço login no sistema como administrador
    E clico no ícone da foto de perfil admin
    Quando clico em ‘Sair’
    Então devo ser redirecionado para a página de ‘Login’
