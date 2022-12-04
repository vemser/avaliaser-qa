package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.DashboardInstrutorPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class DashboardInstrutorSteps {

    DashboardInstrutorPage dashboardInstrutorPage = new DashboardInstrutorPage();

    @Entao("devo visualizar nome do usuário instrutor e foto na tela")
    public void validarNomeEFoto(){
        String validarLogin = dashboardInstrutorPage.validarNomeInstrutorLogado();
        Assert.assertTrue(validarLogin.contains("Instrutor"));
    }

    @Quando("clico em ‘Cadastrar Feedback’")
    public void cadastrarFeedback() {
        dashboardInstrutorPage.clicarBtnCadastrarFeedback();
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Feedback’")
    public void validarRedirecionamentoTelaCadastroFeedback(){
        Assert.assertTrue(dashboardInstrutorPage.validarUrlAtual().contains("/cadastrar-feedback"));
    }

    @Quando("clico em ‘Dashboard’")
    public void clicarDashboard() {
        dashboardInstrutorPage.clicarBtnDashboard();
    }

    @Entao("devo ser redirecionado para a página de ‘Dashboard’")
    public void validarRedirecionamentoTelaDashboard(){
        Assert.assertTrue(dashboardInstrutorPage.validarUrlAtual().contains("/dashboard/instrutor"));
    }

    @Quando("clico em ‘Lista feedbacks’")
    public void clicarListaFeedback() {
        dashboardInstrutorPage.clicarBtnListaFeedback();
    }

    @Entao("devo ser redirecionado para a página de ‘Lista Feedback’")
    public void validarRedirecionamentoTelaListaFeedback(){
        Assert.assertTrue(dashboardInstrutorPage.validarUrlAtual().contains("/lista-feedback"));
    }

    @Quando("clico em um aluno")
    public void clicarDetalhesAluno() {
        dashboardInstrutorPage.abrirDetalhesAluno();
    }

    @Entao("devo ser redirecionado para a página de ‘Detalhes do Aluno’")
    public void validarRedirecionamentoDetalhesAluno(){
        Assert.assertTrue(dashboardInstrutorPage.validarUrlAtual().contains("/verificar-aluno"));

    }

    @E("clico no ícone da foto de perfil instrutor")
    public void clicarBotaoFotoDePerfil() {
        dashboardInstrutorPage.clicarMenuPerfil();
    }

    @Quando("clico em ‘Cadastrar Aluno’ como instrutor")
    public void clicarBotaoCadastrarAlunoInstrutor() {
        dashboardInstrutorPage.clicarBtnCadastrarAlunoInstrutor();
    }

    @E("que acesso a página de Cadastrar Feedback")
    public void acessarPaginaCadastrarFeedback() throws InterruptedException {
        Thread.sleep(5000);
        dashboardInstrutorPage.clicarBtnMenu();
        dashboardInstrutorPage.clicarBtnCadastrarFeedback();
    }

}
