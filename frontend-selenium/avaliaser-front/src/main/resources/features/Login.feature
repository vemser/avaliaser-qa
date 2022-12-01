#language:pt

@test
Funcionalidade: Login

  Contexto: O usuario deve entrar no sistema com login

  @wip
  Cenario: Validar login para Administrador preenchendo campos válidos com sucesso
    Dado que estou na página inicial de login
    E que preencho o campo email Admim válido
    E que preencho o campo senha Admim válida
    Quando clico em ‘Entrar’
    Então devo ser redirecionado para a página principal de administrador e visualizar mensagem de boas-vindas

  @wip
  Cenario: Validar login para Gestor de Pessoas preenchendo campos válidos com sucesso
    Dado que estou na página inicial de login
    E que preencho o campo email Gestor válido
    E que preencho o campo senha Gestor válida
    Quando clico em ‘Entrar’
    Então devo ser redirecionado para a página principal de gestor de pessoas e visualizar mensagem de boas-vindas

#  @wip
#  Cenario: Validar login para Instrutor preenchendo campos válidos com sucesso
#    Dado que estou na página inicial de login
#    E que preencho o campo email Instrutor válido
#    E que preencho o campo senha Instrutor válida
#    Quando clico em ‘Entrar’
#    Então devo ser redirecionado para a página principal de instrutor e visualizar mensagem de boas-vindas

  @smoke
  Cenario: Validar tentativa de login preenchendo campos inválidos
    Dado que estou na página inicial de login
    E que preencho o campo com email inválido
    E que preencho o campo com senha inválida
    Quando clico em ‘Entrar’
    Então devo visualizar mensagem de erro email ou senha

  @smoke
  Cenario:  Validar tentativa de login com usuário inválido
    Dado que estou na página inicial de login
    E que preencho o campo com email inválido
    E que preencho o campo senha válido
    Quando clico em ‘Entrar’
    Então devo visualizar mensagem de erro Email

  @smoke
  Cenario: Validar tentativa de login com senha inválida
    Dado que estou na página inicial de login
    E que preencho o campo com email válido
    E que preencho o campo com senha inválida
    Quando clico em ‘Entrar’
    Então devo visualizar mensagem de erro Senha

  @smoke
  Cenario: Validar tentativa de login sem preencher campos obrigatórios
    Dado que estou na página inicial de login
    E que não preencho o campo email
    E que não preencho o campo senha
    Quando clico em ‘Entrar’
    Então devo validar mensagem de erro ao realizar tentativa de login sem preencher campo Email
    E devo validar mensagem de erro ao realizar tentativa de login sem preencher campo Senha

  @smoke
  Cenario: Validar tentativa de login sem preencher usuário
    Dado que estou na página inicial de login
    E que não preencho o campo email
    E que preencho o campo senha válido
    Quando clico em ‘Entrar’
    Então devo validar mensagem de erro ao realizar tentativa de login sem preencher campo Email

  @smoke
  Cenario:  Validar tentativa de login sem preencher senha
    Dado que estou na página inicial de login
    E que preencho o campo com email válido
    E que não preencho o campo senha
    Quando clico em ‘Entrar’
    Então devo validar mensagem de erro ao realizar tentativa de login sem preencher campo Senha

  @smoke
   Cenario: Validar botão de exibir senha
     Dado que estou na página inicial de login
     E que preencho o campo senha válido
     Quando clico no botão ‘Mostrar’
     Então devo visualizar a senha digitada na tela

  @smoke
  Cenario:  Validar link ‘Esqueci minha senha’
    Dado que estou na página inicial de login
    Quando clico no link ‘Redefinir senha’
    Então devo validar modal para a mudança de senha