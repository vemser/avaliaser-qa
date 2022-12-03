package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.BasePage;
import br.com.dbccompany.vemser.avaliaser.pages.LoginPage;
import br.com.dbccompany.vemser.avaliaser.pages.PrincipalInstrutorPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class PaginaPrincipalInstrutorSteps {

    LoginPage loginPage = new LoginPage();
    PrincipalInstrutorPage principalInstrutorPage = new PrincipalInstrutorPage();

    @Dado("que estou logado no sistema como instrutor")
    public void loginInstrutor(){
        loginPage.preencherCampoEmailValido("mayra.amaral@dbccompany.com.br");
        loginPage.preencherCampoSenhaValida("a!0SC*C9");
        loginPage.clicarBotaoEntrar();
    }

    @Entao("devo visualizar nome do usuário instrutor e foto na tela")
    public void validarNomeEFoto(){
        String validarLogin = principalInstrutorPage.validarNomeInstrutorLogado();
        Assert.assertTrue(validarLogin.contains("Instrutor"));
    }

    @Quando("clico em ‘Cadastrar Aluno’")
    public void cadastrarAluno() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarBtnMenu();
        principalInstrutorPage.clicarBtnCadastrarAluno();
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Aluno’")
    public void validarRedirecionamentoTelaCadastroAluno(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/cadastrar-aluno", principalInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em ‘Cadastrar Feedback’")
    public void cadastrarFeedback() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarBtnMenu();
        principalInstrutorPage.clicarBtnCadastrarFeedback();
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Feedback’")
    public void validarRedirecionamentoTelaCadastroFeedback(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/cadastrar-feedback", principalInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em ‘Dashboard’")
    public void clicarDashboard() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarBtnMenu();
        principalInstrutorPage.clicarBtnDashboard();
    }

    @Entao("devo ser redirecionado para a página de ‘Dashboard’")
    public void validarRedirecionamentoTelaDashboard(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/dashboard/instrutor", principalInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em ‘Sair’")
    public void clicarSair() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarMenuPerfil();
        principalInstrutorPage.clicarBtnSair();
    }

    @Entao("devo ser redirecionado para a página de ‘Login’")
    public void validarRedirecionamentoTelaLogin(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app", principalInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em ‘Lista Feedback’")
    public void clicarListaFeedback() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarBtnMenu();
        principalInstrutorPage.clicarBtnListaFeedback();
    }

    @Entao("devo ser redirecionado para a página de ‘Lista Feedback’")
    public void validarRedirecionamentoTelaListaFeedback(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/lista-feedback", principalInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em Menu-Perfil")
    public void clicarMenuPerfil() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarMenuPerfil();
    }

    @E("que clico em ‘trocar senha’")
    public void clicarTrocarSenha(){
        principalInstrutorPage.clicarBtnTrocarSenha();
    }

    @Entao("devo ser redirecionado para a página de ‘Troca de Senha’")
    public void validarRedirecionamentoTelaTrocaSenha(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/alterar-senha", principalInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em `Editar`")
    public void clicarEditarPerfil() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarMenuPerfil();
        principalInstrutorPage.clicarEditarPerfil();
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Perfil’")
    public void validarRedirecionamentoTelaEditarPerfil(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/editar-usuario", principalInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em um aluno")
    public void clicarDetalhesAluno() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.abrirDetalhesAluno();
    }

    @Entao("devo ser redirecionado para a página de ‘Detalhes do Aluno’")
    public void validarRedirecionamentoDetalhesAluno(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/verificar-aluno", principalInstrutorPage.validarUrlAtual());

    }

    @Quando("clico em editar um aluno")
    public void clicarEditarAluno() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarBtnEditarAluno();
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Aluno’")
    public void validarRedirecionamentoCEditarAluno(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/editar-aluno", principalInstrutorPage.validarUrlAtual());

    }

    @Quando("clico em excluir um aluno")
    public void clicarExcluirAluno() throws InterruptedException {
        Thread.sleep(5000);
        principalInstrutorPage.clicarBtnExcluirAluno();
    }

    @Entao("devo validar modal para confirmar a exclusão")
    public void validarModalExclusaoAluno() throws InterruptedException {
        Thread.sleep(5000);
        String modalExcluirAluno = principalInstrutorPage.validarModalExclusaoAluno();
        Assert.assertTrue(modalExcluirAluno.contains("Você realmente deseja excluir?"));
    }

    @E("clico em ´Confirmar´ no modal de confirmação")
    public void confirmarExcluirAluno(){
        principalInstrutorPage.clicarConfirmarExcluirAluno();
    }

    @Entao("devo validar mensagem de exclusão concluída")
    public void validarMensagemAlunoExcluido(){
        Assert.assertEquals("Aluno desativado com sucesso.",principalInstrutorPage.validarExclusaoAluno());
    }

}
