#language:pt

@test
Funcionalidade: Pagina Principal Instrutor

    @wip
    Cenario: Validar exibição de dados de usuário instrutor com sucesso
    Dado que faço login no sistema como instrutor
    Então devo visualizar nome do usuário instrutor e foto na tela

    @wip
    Cenario: Validar redirecionamento ‘Cadastrar Aluno’ com sucesso
    Dado que faço login no sistema como instrutor
    E que clico em 'Menu'
    Quando clico em ‘Cadastrar Aluno’
    Então devo ser redirecionado para a página de ‘Cadastrar Aluno’

    @wip
    Cenario: Validar botão ‘Lista feedbacks’ com sucesso
        Dado que faço login no sistema como instrutor
        E que clico em 'Menu'
        Quando clico em ‘Lista feedbacks’
        Então devo ser redirecionado para a página de ‘Lista Feedback’’

    @wip
    Cenario: Validar botão ‘Cadastrar Aluno’ com sucesso
        Dado que faço login no sistema como gestor
        E que clico em 'Menu'
        Quando clico em ‘Cadastrar Aluno’
        Então devo ser redirecionado para a página de ‘Cadastrar Aluno’

    @wip
    Cenario: Validar redirecionamento ‘Cadastrar Feedback’ com sucesso
    Dado que faço login no sistema como instrutor
    E que clico em 'Menu'
    Quando clico em ‘Cadastrar Feedback’
    Então devo ser redirecionado para a página de ‘Cadastrar Feedback’

    @wip
    Cenario: Validar botão ‘Dashboard’ com sucesso
    Dado que faço login no sistema como instrutor
    E que clico em 'Menu'
    Quando clico em ‘Dashboard’
    Então devo ser redirecionado para a página de ‘Dashboard’


    @wip
    Cenario: Validar botão ‘trocar senha’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em Menu-Perfil
        E que clico em ‘trocar senha’
        Então devo ser redirecionado para a página de ‘Troca de Senha’

    @wip
    Cenario: Validar botão ‘editar perfil’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em `Editar`
        Então devo ser redirecionado para a página de ‘Editar Perfil’

    @wip
    Cenario: Validar botão ‘detalhes do aluno’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em um aluno
        Então devo ser redirecionado para a página de ‘Detalhes do Aluno’

    @wip
    Cenario: Validar botão ‘editar aluno’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em editar um aluno
        Então devo ser redirecionado para a página de ‘Editar Aluno’

    @wip
    Cenario: Validar modal ‘excluir aluno’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em excluir um aluno
        Então devo validar modal para confirmar a exclusão

    @wip
    Cenario: Validar ‘excluir aluno’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em excluir um aluno
        E clico em ´Confirmar´ no modal de confirmação
        Então devo validar mensagem de exclusão concluída