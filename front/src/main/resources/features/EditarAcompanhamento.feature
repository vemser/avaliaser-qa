#language:pt

@test
Funcionalidade: Editar Acompanhamento

  Contexto: O usuário deve editar acompanhamento

  @smoke
  Cenario: Validar edição de acompanhamento com sucesso
    Dado que faço login no sistema como gestor
    E que acesso a página de ‘Lista acompanhamentos’
    E clico em ‘Editar’ um acompanhamento
    E que altero título acompanhamento válido
    E que altero descrição acompanhamento válido
    Quando clico em ‘Editar’ acompanhamento para salvar alteração
    Então devo visualizar mensagem de confirmação de edição e ser redirecionado para a página lista Acompanhamentos

  @smoke
  Cenario: Validar tentativa de edição de acompanhamento com título vazio
    Dado que faço login no sistema como gestor
    E que acesso a página de ‘Lista acompanhamentos’
    E clico em ‘Editar’ um acompanhamento
    E que altero título acompanhamento para vazio
    E que altero descrição acompanhamento válido
    Quando clico em ‘Editar’ acompanhamento para salvar alteração
    Então devo visualizar mensagem de erro para título vazio

  @smoke
  Cenario: Validar tentativa de edição de acompanhamento com descrição vazio
    Dado que faço login no sistema como gestor
    E que acesso a página de ‘Lista acompanhamentos’
    E clico em ‘Editar’ um acompanhamento
    E que altero título acompanhamento válido
    E que altero descrição acompanhamento para vazio
    Quando clico em ‘Editar’ acompanhamento para salvar alteração
    Então devo visualizar mensagem de erro para descrição vazio


