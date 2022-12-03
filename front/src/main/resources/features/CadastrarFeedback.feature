#language:pt

@test
Funcionalidade: Pagina Principal Instrutor

  Contexto: O usuario deve acessar página principal de Administrador

@smoke
Cenario: Validar ‘Cadastrar Feedback’ com sucesso
Dado que faço login no sistema como instrutor
E que clico em 'Menu'
Quando clico em ‘Cadastrar Feedback’
E seleciono a stack
E seleciono o aluno
E preencho o campo ´Descrição´
E seleciono o status
E clico em enviar
Então devo validar mensagem de Feedback cadastrado com sucesso