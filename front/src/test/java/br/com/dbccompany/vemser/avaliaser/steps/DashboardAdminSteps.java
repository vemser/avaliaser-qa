package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.DashboardAminPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class DashboardAdminSteps {

    DashboardAminPage dashboardAminPage = new DashboardAminPage();

    @E("clico em ‘Deletar Colaborador’")
    public void clicarBotaoDeletarColaborador() {
        dashboardAminPage.clicarBtnDeletarColaborador();
    }

    @E("clico no ícone da foto de perfil admin")
    public void clicarBotaoFotoDePerfil() {
        dashboardAminPage.clicarBtnFotoPerfil();
    }

    @Quando("clico em ‘Cadastrar Colaborador’")
    public void clicarBotaoCadastrarColaborador() {
        dashboardAminPage.clicarBtnCadastrarColaborador();
    }

    @Quando("clico em um colaborador")
    public void clicarLinkColaborador() {
        dashboardAminPage.clicarColaborador();
    }

    @Quando("clico em ‘Editar Colaborador’")
    public void clicarBotaoEditarColaborador() {
        dashboardAminPage.clicarBtnEditarColaborador();
    }

    @Quando("clico em ‘Confirmar’")
    public void clicarBotaoConfirmarDeletar() {
        dashboardAminPage.clicarBtnConfirmarDeletar();
    }

    @Entao("devo visualizar mensagem de boas-vindas e lista de colaboradores na tela")
    public void paginaPrincipalAdmin() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(dashboardAminPage.validarTextoDashboardAdmin().contains("Dashboard Colaboradores"));
        Assert.assertTrue(dashboardAminPage.validarMensagemDeBoasVindasAdmin().contains("Seja bem-vindo(a)"));
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Colaborador’")
    public void paginaCadastrarColaborador() {
        Assert.assertTrue(dashboardAminPage.validarUrlAtual().contains("/cadastrar-colaborador"));
    }

    @Entao("devo visualizar detalhes deste colaborador")
    public void paginaDetalhesColaborador() {
        Assert.assertTrue(dashboardAminPage.validarUrlAtual().contains("/detalhes-colaborador"));
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Colaborador’")
    public void paginaEditarColaborador() {
        Assert.assertTrue(dashboardAminPage.validarUrlAtual().contains("/editar-colaborador"));
    }

    @Entao("devo visualizar mensagem de confirmação na tela")
    public void mensagemConfirmacaoColaboradorDeletado() {
        Assert.assertEquals("Colaborador desativado com sucesso.",
                dashboardAminPage.validarMensagemDeColaboradorDeletado());
    }

    @E("que acesso a página de Editar Usuário admin")
    public void acessarPaginaEditarUsuarioAdmin() throws InterruptedException {
        Thread.sleep(5000);
        dashboardAminPage.clicarBtnFotoPerfil();
        dashboardAminPage.clicarBtnEditar();
    }

    @E("que acesso a página de Alterar Senha de usuário logado admin")
    public void acessarPaginaAlterarSenhaUsuarioLogado() throws InterruptedException {
        Thread.sleep(5000);
        dashboardAminPage.clicarBtnFotoPerfil();
        dashboardAminPage.clicarBtnTrocarSenha();
    }

    @E("que acesso a página de Cadastrar Colaborador")
    public void acessarPaginaCadastrarColaborador() throws InterruptedException {
        Thread.sleep(5000);
        dashboardAminPage.clicarBtnMenu();
        dashboardAminPage.clicarBtnCadastrarColaborador();
    }

    @E("que acesso a página de Editar Colaborador")
    public void acessarPaginaEditarColaborador() throws InterruptedException {
        Thread.sleep(5000);
        dashboardAminPage.clicarBtnEditarColaborador();
    }

}
