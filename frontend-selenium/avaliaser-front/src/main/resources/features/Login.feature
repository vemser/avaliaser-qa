#language:pt

@test
Funcionalidade: Login

  Contexto: O usuario deve entrar com tentativa de login

  @wip
  Cenario: Validar página inicial sem usuário logado com sucesso
    Dado que acesso o sistema AvaliaSer sem estar logado
    Então devo visualizar a página de Login
