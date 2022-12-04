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
  Cenario: Validar tentativa de cadastro de aluno sem preencher campos obrigatórios
    Dado que faço login no sistema como gestor
    E que acesso a página de Cadastrar Aluno
    Quando clico em ‘Enviar’ para salvar cadastro de aluno
    Então devo visualizar mensagens de erro campos obrigatórios para cadastrar aluno

  @smoke
  Cenario: Validar tentativa de cadastro de aluno com email inválido
    Dado que faço login no sistema como gestor
    E que acesso a página de Cadastrar Aluno
    E que preencho o campo nome de aluno válido
    E que preencho o campo email de aluno inválido
    Quando clico em ‘Enviar’ para salvar cadastro de aluno
    Então devo visualizar mensagem de erro para email de cadastrar aluno inválido