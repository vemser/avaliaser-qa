#language:pt

@test
Funcionalidade: Editar Senha Usuário Logado

  Contexto: O usuario logado deve editar sua senha no sistema

  @smoke
  Cenario: Validar edição de senha de usuário logado com sucesso
    Dado que faço login no sistema como administrador
    E que acesso a página de Alterar Senha de usuário logado admin
    E que preencho o campo senha antiga válido
    E que preencho o campo senha nova válido
    E que preencho o campo confirme senha nova válido
    Quando clico em Enviar alteração de senha
    Então devo visualizar mensagem de confirmação de edição de senha e ser redirecionado para a página Dashboard

  @smoke
  Cenario: Validar tentativa de edição de senha de usuário logado com senha antiga inválida
    Dado que faço login no sistema como administrador
    E que acesso a página de Alterar Senha de usuário logado admin
    E que preencho o campo senha antiga inválido
    E que preencho o campo senha nova válido
    E que preencho o campo confirme senha nova válido
    Quando clico em Enviar alteração de senha
    Então devo visualizar mensagem de erro para senha antiga inválida

  @smoke
  Cenario: Validar tentativa de edição de senha de usuário logado com senha antiga vazio
    Dado que faço login no sistema como administrador
    E que acesso a página de Alterar Senha de usuário logado admin
    E que preencho o campo senha nova válido
    E que preencho o campo confirme senha nova válido
    Quando clico em Enviar alteração de senha
    Então devo visualizar mensagem de erro para senha antiga vazio

  @smoke
  Cenario: Validar tentativa de edição de senha de usuário logado com senha nova inválida
    Dado que faço login no sistema como administrador
    E que acesso a página de Alterar Senha de usuário logado admin
    E que preencho o campo senha antiga válido
    E que preencho o campo senha nova inválido
    E que preencho o campo confirme senha nova inválido
    Quando clico em Enviar alteração de senha
    Então devo visualizar mensagem de erro para senha nova inválida

  @smoke
  Cenario: Validar tentativa de edição de senha de usuário logado com senha nova vazio
    Dado que faço login no sistema como administrador
    E que acesso a página de Alterar Senha de usuário logado admin
    E que preencho o campo senha antiga válido
    Quando clico em Enviar alteração de senha
    Então devo visualizar mensagem de erro para senha nova vazio

  @smoke
  Cenario: Validar tentativa de edição de senha de usuário logado com confirmação de senha inválido
    Dado que faço login no sistema como administrador
    E que acesso a página de Alterar Senha de usuário logado admin
    E que preencho o campo senha antiga válido
    E que preencho o campo senha nova válido
    E que preencho o campo confirme senha nova inválido
    Quando clico em Enviar alteração de senha
    Então devo visualizar mensagem de erro para confirma senha nova inválida

  @smoke
  Cenario: Validar tentativa de edição de senha de usuário logado com confirmação de senha vazio
    Dado que faço login no sistema como administrador
    E que acesso a página de Alterar Senha de usuário logado admin
    E que preencho o campo senha antiga válido
    E que preencho o campo senha nova válido
    Quando clico em Enviar alteração de senha
    Então devo visualizar mensagem de erro para confirma senha nova vazio