#language:pt

@test
Funcionalidade: Dashboard Admin

  Contexto: O usuario deve acessar página principal de Administrador

  @smoke
  Cenario: Validar login para Administrador preenchendo campos válidos com sucesso
    Dado que estou na página inicial de login
    E que preencho o campo email Admim válido
    E que preencho o campo senha Admim válida
    Quando clico em ‘Entrar’
    Então devo ser redirecionado para a página principal de administrador e visualizar mensagem de boas-vindas