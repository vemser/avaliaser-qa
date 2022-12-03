package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.LoginPage;
import br.com.dbccompany.vemser.avaliaser.pages.DashboardInstrutorPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class DashboardInstrutorSteps {

    LoginPage loginPage = new LoginPage();
    DashboardInstrutorPage dashboardInstrutorPage = new DashboardInstrutorPage();


    @Entao("devo visualizar nome do usuário instrutor e foto na tela")
    public void validarNomeEFoto(){
        String validarLogin = dashboardInstrutorPage.validarNomeInstrutorLogado();
        Assert.assertTrue(validarLogin.contains("Instrutor"));
    }


    @Entao("devo ser redirecionado para a página de ‘Cadastrar Aluno’")
    public void validarRedirecionamentoTelaCadastroAluno(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/cadastrar-aluno", dashboardInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em ‘Cadastrar Feedback’")
    public void cadastrarFeedback() throws InterruptedException {
        Thread.sleep(5000);
        dashboardInstrutorPage.clicarBtnMenu();
        dashboardInstrutorPage.clicarBtnCadastrarFeedback();
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Feedback’")
    public void validarRedirecionamentoTelaCadastroFeedback(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/cadastrar-feedback", dashboardInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em ‘Dashboard’")
    public void clicarDashboard() throws InterruptedException {
        Thread.sleep(5000);
        dashboardInstrutorPage.clicarBtnMenu();
        dashboardInstrutorPage.clicarBtnDashboard();
    }

    @Entao("devo ser redirecionado para a página de ‘Dashboard’")
    public void validarRedirecionamentoTelaDashboard(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/dashboard/instrutor", dashboardInstrutorPage.validarUrlAtual());
    }



    @Quando("clico em ‘Lista Feedback’")
    public void clicarListaFeedback() throws InterruptedException {
        Thread.sleep(5000);
        dashboardInstrutorPage.clicarBtnMenu();
        dashboardInstrutorPage.clicarBtnListaFeedback();
    }

    @Entao("devo ser redirecionado para a página de ‘Lista Feedback’")
    public void validarRedirecionamentoTelaListaFeedback(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/lista-feedback", dashboardInstrutorPage.validarUrlAtual());
    }

    @Quando("clico em Menu-Perfil")
    public void clicarMenuPerfil() throws InterruptedException {
        Thread.sleep(5000);
        dashboardInstrutorPage.clicarMenuPerfil();
    }

    @E("que clico em ‘trocar senha’")
    public void clicarTrocarSenha(){
        dashboardInstrutorPage.clicarBtnTrocarSenha();
    }

    @Entao("devo ser redirecionado para a página de ‘Troca de Senha’")
    public void validarRedirecionamentoTelaTrocaSenha(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/alterar-senha", dashboardInstrutorPage.validarUrlAtual());
    }


    @Quando("clico em um aluno")
    public void clicarDetalhesAluno() throws InterruptedException {
        Thread.sleep(5000);
        dashboardInstrutorPage.abrirDetalhesAluno();
    }

    @Entao("devo ser redirecionado para a página de ‘Detalhes do Aluno’")
    public void validarRedirecionamentoDetalhesAluno(){
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/verificar-aluno", dashboardInstrutorPage.validarUrlAtual());

    }


}
