#language:pt

@test
Funcionalidade: Dashboard Gestor

  Contexto: O usuario deve acessar página principal de Gestor de Pessoas

  @smoke
  Cenario: Validar página Dashboard Gestor de Pessoas com sucesso
    Dado que faço login no sistema como gestor
    Então devo visualizar mensagem de boas-vindas e lista de alunos na tela

  @smoke
  Cenario: Validar botão ‘Lista acompanhamentos’ com sucesso
    Dado que faço login no sistema como gestor
    E que clico em 'Menu'
    Quando clico em ‘Lista acompanhamentos’
    Então devo ser redirecionado para a página de ‘Lista Acompanhamentos’

  @smoke
  Cenario: Validar botão ‘Cadastrar Aluno’ com sucesso
    Dado que faço login no sistema como gestor
    E que clico em 'Menu'
    Quando clico em ‘Cadastrar Aluno’
    Então devo ser redirecionado para a página de ‘Cadastrar Aluno’

  @smoke
  Cenario: Validar botão ‘Cadastrar Acompanhamento’ com sucesso
    Dado que faço login no sistema como gestor
    E que clico em 'Menu'
    Quando clico em ‘Cadastrar Acompanhamento’
    Então devo ser redirecionado para a página de ‘Cadastrar Acompanhamento’

  @smoke
  Cenario: Validar botão ‘Avaliar Acompanhamento’ com sucesso
    Dado que faço login no sistema como gestor
    E que clico em 'Menu'
    Quando clico em ‘Avaliar Acompanhamento’
    Então devo ser redirecionado para a página de ‘Avaliar Acompanhamento’

  @smoke
  Cenario: Validar botão ‘Editar Aluno’ com sucesso
    Dado que faço login no sistema como gestor
    Quando clico em ‘Editar Aluno’
    Então devo ser redirecionado para a página de ‘Editar Aluno’

  @falta
  Cenario: Validar botão ‘Deletar Aluno’ com sucesso
    Dado que faço login no sistema como gestor
    E clico em ‘Deletar Aluno’
    Quando clico em ‘Confirmar’ para deletar aluno
    Então devo visualizar mensagem de confirmação para aluno deletado

  @smoke
  Cenario: Validar botão ‘Trocar Senha’ com sucesso
    Dado que faço login no sistema como gestor
    E clico no ícone da foto de perfil gestor
    Quando clico em ‘Trocar Senha’
    Então devo ser redirecionado para a página de ‘Alterar Senha’

  @smoke
  Cenario: Validar botão ‘Editar’ com sucesso
    Dado que faço login no sistema como gestor
    E clico no ícone da foto de perfil gestor
    Quando clico em ‘Editar Usuário’
    Então devo ser redirecionado para a página de ‘Editar Usuário’

  @smoke
  Cenario: Validar botão ‘Sair’ com sucesso
    Dado que faço login no sistema como gestor
    E clico no ícone da foto de perfil gestor
    Quando clico em ‘Sair’
    Então devo ser redirecionado para a página de ‘Login’
