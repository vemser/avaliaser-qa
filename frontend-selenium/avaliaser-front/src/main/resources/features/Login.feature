#language:pt

@test
Funcionalidade: Entrar

  Contexto: O usuario deve entrar com tentativa de login


  Cenario: Validar página inicial sem usuário logado com sucesso
    Dado que acesso o sistema AvaliaSer sem estar logado
    Então devo visualizar a página de Login

   Cenario: Validar tentativa de login preenchendo campos inválidos
    Dado que estou na página inicial de login
    E que preencho o campo email inválido
    E que preencho o campo senha inválido
    Quando clico em ‘Entrar’
    Então devo visualizar mensagem de erro padrão

  @wip
  Cenario:  Validar tentativa de login com usuário inválido
    Dado que estou na página inicial de login
    E que preencho o campo com email inválido
    E que preencho o campo senha válido
    Quando clico em ‘Entrar’
    Então devo visualizar mensagem de erro Email

  @wip
    Cenario: Validar tentativa de login com senha inválida
      Dado que estou na página inicial de login
      E que preencho o campo com email válido
      E que preencho o campo com senha inválida
      Quando clico em ‘Entrar’
      Então devo visualizar mensagem de erro Senha


      Cenario: Validar tentativa de login sem preencher campos obrigatórios
        Dado que estou na página inicial de login
        E que não preencho o campo usuário
        E que não preencho o campo senha
        Quando clico em ‘Entrar’
        Então devo visualizar mensagem de erro padrão


