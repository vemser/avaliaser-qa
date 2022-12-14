package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.DashboardGestorPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class DashboardGestorSteps {

    DashboardGestorPage dashboardGestorPage = new DashboardGestorPage();

    @E("clico no ícone da foto de perfil gestor")
    public void clicarBotaoFotoDePerfil() {
        dashboardGestorPage.clicarBtnFotoPerfil();
    }

    @Quando("clico em ‘Lista acompanhamentos’")
    public void clicarBotaoListaAcompanhamentos() {
        dashboardGestorPage.clicarBtnListaAcompanhamentos();
    }

    @Quando("clico em ‘Cadastrar Acompanhamento’")
    public void clicarBotaoCadastrarAcompanhamento() {
        dashboardGestorPage.clicarBtnCadastrarAcompanhamento();
    }

    @Quando("clico em ‘Avaliar Acompanhamento’")
    public void clicarBotaoAvaliarAcompanhamento() {
        dashboardGestorPage.clicarBtnAvaliarAcompanhamento();
    }

    @Quando("clico em ‘Cadastrar Aluno’ como gestor")
    public void clicarBotaoCadastrarAlunoGestor() {
        dashboardGestorPage.clicarBtnCadastrarAlunoGestor();
    }

    @Entao("devo visualizar mensagem de boas-vindas e lista de alunos na tela")
    public void paginaPrincipalAdmin() {
        Assert.assertEquals("Dashboard Alunos", dashboardGestorPage.validarTextoDashboardGestor());
        Assert.assertTrue(dashboardGestorPage.validarMensagemDeBoasVindasGestor().contains("Seja bem-vindo(a)"));
    }

    @Entao("devo ser redirecionado para a página de ‘Lista Acompanhamentos’")
    public void paginaListaAcompanhamentos() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/lista-acompanhamento"));
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Acompanhamento’")
    public void paginaCadastrarAcompanhamento() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/cadastrar-acompanhamento"));
    }

    @Entao("devo ser redirecionado para a página de ‘Avaliar Acompanhamento’")
    public void paginaAvaliarAcompanhamento() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/avaliar-acompanhamento"));
    }

    @E("que acesso a página de ‘Lista acompanhamentos’")
    public void acessarPaginaListaAcompanhamentos() throws InterruptedException {
        Thread.sleep(5000);
        dashboardGestorPage.clicarBtnMenu();
        dashboardGestorPage.clicarBtnListaAcompanhamentos();
    }

    @E("que acesso a página de Cadastrar Aluno")
    public void acessarPaginaCadastrarAluno() throws InterruptedException {
        Thread.sleep(5000);
        dashboardGestorPage.clicarBtnMenu();
        dashboardGestorPage.clicarBtnCadastrarAlunoGestor();
    }

    @E("que acesso a página de Editar Aluno")
    public void acessarPaginaEditarAluno() throws InterruptedException {
        Thread.sleep(5000);
        dashboardGestorPage.clicarBtnEditarAluno();
    }

}
