#language:pt

@test
Funcionalidade: Pagina Principal Instrutor

    @smoke
    Cenario: Validar exibição de dados de usuário instrutor com sucesso
    Dado que estou logado no sistema como instrutor
    Então devo visualizar nome do usuário instrutor e foto na tela

    @smoke
    Cenario: Validar botão ‘Cadastrar Aluno’ com sucesso
    Dado que estou logado no sistema como instrutor
    Quando clico em ‘Cadastrar Aluno’
    Então devo ser redirecionado para a página de ‘Cadastrar Aluno’

    @smoke
    Cenario: Validar botão ‘Cadastrar Feedback’ com sucesso
    Dado que estou logado no sistema como instrutor
    Quando clico em ‘Cadastrar Feedback’
    Então devo ser redirecionado para a página de ‘Cadastrar Feedback’

    @smoke
    Cenario: Validar botão ‘Dashboard’ com sucesso
    Dado que estou logado no sistema como instrutor
    Quando clico em ‘Dashboard’
    Então devo ser redirecionado para a página de ‘Dashboard’

    @smoke
    Cenario: Validar botão ‘Sair’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em ‘Sair’
        Então devo ser redirecionado para a página de ‘Login’


    @smoke
    Cenario: Validar botão ‘Lista Feedback’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em ‘Lista Feedback’
        Então devo ser redirecionado para a página de ‘Lista Feedback’

    @smoke
    Cenario: Validar botão ‘trocar senha’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em Menu-Perfil
        E que clico em ‘trocar senha’
        Então devo ser redirecionado para a página de ‘Troca de Senha’

    @smoke
    Cenario: Validar botão ‘editar perfil’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em `Editar`
        Então devo ser redirecionado para a página de ‘Editar Perfil’

    @smoke
    Cenario: Validar botão ‘detalhes do aluno’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em um aluno
        Então devo ser redirecionado para a página de ‘Detalhes do Aluno’

    @smoke
    Cenario: Validar botão ‘editar aluno’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em editar um aluno
        Então devo ser redirecionado para a página de ‘Editar Aluno’

    @smoke
    Cenario: Validar modal ‘excluir aluno’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em excluir um aluno
        Então devo validar modal para confirmar a exclusão

    @wip
    Cenario: Validar ‘excluir aluno’ com sucesso
        Dado que estou logado no sistema como instrutor
        Quando clico em excluir um aluno
        E clico em ´Confirmar´ no modal de confirmação
        Então devo validar mensagem de exclusão concluída