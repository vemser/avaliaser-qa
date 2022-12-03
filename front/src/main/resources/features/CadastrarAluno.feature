#language:pt

@test
Funcionalidade: Cadastrar Aluno

Contexto: O usuario deve acessar página principal de Administrador

@smoke
  Cenario: Validar Cadastro Aluno preenchendo campos válidos com sucesso
    Dado que estou logado no sistema como instrutor ou gestor
    E que preencho o campo email Admim válido
    E que preencho o campo senha Admim válida
    Quando clico em ‘Entrar’
    Então devo ser redirecionado para a página principal de administrador e visualizar mensagem de boas-vindas