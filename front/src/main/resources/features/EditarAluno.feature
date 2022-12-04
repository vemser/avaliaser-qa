#language:pt

@test
Funcionalidade: Editar Aluno

  Contexto: O usuario deve editar aluno no sistema

  @smoke
  Cenario: Validar edição de aluno com sucesso
    Dado que faço login no sistema como gestor
    E que acesso a página de Editar Aluno
    E que altero o campo nome de aluno válido
    E que altero o campo email de aluno válido
    Quando clico em ‘Editar’ para salvar alteração de aluno
    Então devo visualizar mensagem de sucesso de aluno editado e ser redirecionado para a página Dashboard

  @smoke
  Cenario: Validar tentativa de edição de aluno sem preencher campos obrigatórios
    Dado que faço login no sistema como gestor
    E que acesso a página de Editar Aluno
    E que altero o campo nome de aluno para vazio
    E que altero o campo email de aluno para vazio
    Quando clico em ‘Editar’ para salvar alteração de aluno
    Então devo visualizar mensagens de erro campos obrigatórios para editar aluno

  @smoke
  Cenario: Validar tentativa de edição de aluno com email inválido
    Dado que faço login no sistema como gestor
    E que acesso a página de Editar Aluno
    E que altero o campo nome de aluno válido
    E que altero o campo email de aluno inválido
    Quando clico em ‘Editar’ para salvar alteração de aluno
    Então devo visualizar mensagem de erro para email de editar aluno inválido