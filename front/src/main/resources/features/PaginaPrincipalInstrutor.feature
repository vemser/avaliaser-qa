#language:pt

@test
Funcionalidade: Pagina Principal Instrutor

    Cenario: Validar exibição de dados de usuário instrutor com sucesso
    Dado que estou logado no sistema como instrutor
    Então devo visualizar nome do usuário instrutor e foto na tela

    Cenario: Validar botão ‘Cadastrar Aluno’ com sucesso
    Dado que estou logado no sistema como instrutor
    Quando clico em ‘Cadastrar Aluno’
    Então devo ser redirecionado para a página de ‘Cadastrar Aluno’

    Cenario: Validar botão ‘Cadastrar Feedback’ com sucesso
    Dado que estou logado no sistema como instrutor
    Quando clico em ‘Cadastrar Feedback’
    Então devo ser redirecionado para a página de ‘Cadastrar Feedback’

    Cenario: Validar botão ‘Dashboard’ com sucesso
    Dado que estou logado no sistema como instrutor
    Quando clico em ‘Dashboard’
    Então devo ser redirecionado para a página de ‘Dashboard’

    Cenario: Validar botão ‘Sair’ com sucesso
    Dado que estou logado no sistema como instrutor
    Quando clico em ‘Sair’
    Então devo ser redirecionado para a página de ‘Login’
