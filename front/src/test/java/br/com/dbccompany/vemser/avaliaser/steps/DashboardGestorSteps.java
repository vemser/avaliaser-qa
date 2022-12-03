package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.DashboardGestorPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class DashboardGestorSteps {

    DashboardGestorPage dashboardGestorPage = new DashboardGestorPage();

    @E("que clico em 'Menu' de gestor")
    public void clicarBotaoMenu() {
        dashboardGestorPage.clicarBtnMenu();
    }

    @E("clico em ‘Deletar Aluno’")
    public void clicarBotaoDeletarAluno() {
        dashboardGestorPage.clicarBtnDeletarAluno();
    }

    @Quando("clico em ‘Lista acompanhamentos’")
    public void clicarBotaoListaAcompanhamentos() {
        dashboardGestorPage.clicarBtnListaAcompanhamentos();
    }

    @Quando("clico em ‘Cadastrar Aluno’")
    public void clicarBotaoCadastrarAluno() {
        dashboardGestorPage.clicarBtnCadastrarAluno();
    }

    @Quando("clico em ‘Cadastrar Acompanhamento’")
    public void clicarBotaoCadastrarAcompanhamento() {
        dashboardGestorPage.clicarBtnCadastrarAcompanhamento();
    }

    @Quando("clico em ‘Avaliar Acompanhamento’")
    public void clicarBotaoAvaliarAcompanhamento() {
        dashboardGestorPage.clicarBtnAvaliarAcompanhamento();
    }

    @Quando("clico em ‘Editar Aluno’")
    public void clicarBotaoEditarAluno() {
        dashboardGestorPage.clicarBtnEditarAluno();
    }

    @Quando("clico em ‘Confirmar’ para deletar aluno")
    public void clicarBotaoConfirmarDeletar() {
        dashboardGestorPage.clicarBtnConfirmarDeletar();
    }

    @Entao("devo visualizar mensagem de boas-vindas e lista de alunos na tela")
    public void paginaPrincipalAdmin() {
        Assert.assertEquals("Dashboard Alunos", dashboardGestorPage.validarTextoDashboardGestor());
        Assert.assertEquals("Seja bem-vindo(a)", dashboardGestorPage.validarMensagemDeBoasVindasGestor());
    }

    @Entao("devo ser redirecionado para a página de ‘Lista Acompanhamentos’")
    public void paginaListaAcompanhamentos() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/acompanhamento/listar-acompanhamento"));
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Aluno’")
    public void paginaCadastrarAluno() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/aluno/cadastrar-aluno"));
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Acompanhamento’")
    public void paginaCadastrarAcompanhamento() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/acompanhamento/cadastrar-acompanhamento"));
    }

    @Entao("devo ser redirecionado para a página de ‘Avaliar Acompanhamento’")
    public void paginaAvaliarAcompanhamento() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/avaliacao-acompanhamento/cadastrar-avaliacao"));
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Aluno’")
    public void paginaEditarAluno() {
        Assert.assertTrue(dashboardGestorPage.validarUrlAtual().contains("/editar-aluno"));
    }

    @Entao("devo visualizar mensagem de confirmação para aluno deletado")
    public void mensagemConfirmacaoAlunoDeletado() {
        Assert.assertEquals("Aluno desativado com sucesso.",
                dashboardGestorPage.validarMensagemDeAlunoDeletado());
    }

}
