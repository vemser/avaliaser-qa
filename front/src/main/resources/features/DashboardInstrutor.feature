#language:pt

@test
Funcionalidade: Dashboard Instrutor

    @smoke
    Cenario: Validar exibição de dados de usuário instrutor com sucesso
        Dado que faço login no sistema como instrutor
        Então devo visualizar nome do usuário instrutor e foto na tela

    @smoke
    Cenario: Validar botão ‘Cadastrar Aluno' com sucesso
        Dado que faço login no sistema como instrutor
        E que clico em 'Menu'
        Quando clico em ‘Cadastrar Aluno’ como instrutor
        Então devo ser redirecionado para a página de ‘Cadastrar Aluno’

    @smoke
    Cenario: Validar botão ‘Lista feedbacks’ com sucesso
        Dado que faço login no sistema como instrutor
        E que clico em 'Menu'
        Quando clico em ‘Lista feedbacks’
        Então devo ser redirecionado para a página de ‘Lista Feedback’

    @smoke
    Cenario: Validar botão ‘Cadastrar Feedback’ com sucesso
        Dado que faço login no sistema como instrutor
        E que clico em 'Menu'
        Quando clico em ‘Cadastrar Feedback’
        Então devo ser redirecionado para a página de ‘Cadastrar Feedback’

    @smoke
    Cenario: Validar botão ‘Dashboard’ com sucesso
        Dado que faço login no sistema como instrutor
        E que clico em 'Menu'
        Quando clico em ‘Dashboard’
        Então devo ser redirecionado para a página de ‘Dashboard’

    @smoke
    Cenario: Validar botão ‘detalhes do aluno’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em um aluno
        Então devo ser redirecionado para a página de ‘Detalhes do Aluno’

    @smoke
    Cenario: Validar botão ‘Editar Aluno’ com sucesso
        Dado que faço login no sistema como instrutor
        Quando clico em ‘Editar Aluno’
        Então devo ser redirecionado para a página de ‘Editar Aluno’

    @smoke
    Cenario: Validar botão ‘Deletar Aluno’ com sucesso
        Dado que faço login no sistema como instrutor
        E clico em ‘Deletar Aluno’
        Quando clico em ‘Confirmar’ para deletar aluno
        Então devo visualizar mensagem de confirmação para aluno deletado

    @smoke
    Cenario: Validar botão ‘Trocar Senha’ com sucesso
        Dado que faço login no sistema como instrutor
        E clico no ícone da foto de perfil instrutor
        Quando clico em ‘Trocar Senha’
        Então devo ser redirecionado para a página de ‘Alterar Senha’

    @smoke
    Cenario: Validar botão ‘Editar’ com sucesso
        Dado que faço login no sistema como instrutor
        E clico no ícone da foto de perfil instrutor
        Quando clico em ‘Editar Usuário’
        Então devo ser redirecionado para a página de ‘Editar Usuário’

    @smoke
    Cenario: Validar botão ‘Sair’ com sucesso
        Dado que faço login no sistema como instrutor
        E clico no ícone da foto de perfil instrutor
        Quando clico em ‘Sair’
        Então devo ser redirecionado para a página de ‘Login’